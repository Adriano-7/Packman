package ldts.pacman.controller.game;

import ldts.pacman.Game;
import ldts.pacman.controller.game.monster.state.ScaredState;
import ldts.pacman.controller.game.movement.strategy.PlayerStrategy;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.Pacman;
import ldts.pacman.sound.SoundObserver;
import ldts.pacman.sound.SoundPacCoin;
import ldts.pacman.sound.SoundPacDies;
import ldts.pacman.sound.SoundPlayer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Observer;

public class PacmanController extends GameController{
    private long lastMovement;
    private PlayerStrategy playerStrategy;
    private List<SoundObserver> observers = new LinkedList<>();
    public void addObserver(SoundObserver observer){
        observers.add(observer);
    }
    public void removeObserver(SoundObserver observer){
        observers.remove(observer);
    }
    public void notifyObservers() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        for(SoundObserver observer : observers){
            observer.onSoundEvent();
        }
    }

    public PacmanController(Arena model) {
        super(model);
        playerStrategy = new PlayerStrategy();
        lastMovement = 0;
    }
    public Pacman getPacman() {
        return getModel().getPacman();
    }

    @Override
    public void step(Game game, List<GUI.OPTION> options, long time) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        playerStrategy.changeDirection(options, getPacman());
        Arena arena = getModel();
        if (time - lastMovement > 200 && playerStrategy.move(getPacman(), arena)) {
            Position pacmanPos = getPacman().getPosition();
            lastMovement = time;
            Monster monster = arena.getCollidingMonster(pacmanPos);
            if (monster != null) {
                monster.getHit(arena);
                SoundPacDies soundPacDies = new SoundPacDies(); addObserver(soundPacDies); notifyObservers();removeObserver(soundPacDies);
            }
            if(arena.collectCoin()){SoundPacCoin sound = new SoundPacCoin();addObserver(sound);notifyObservers();removeObserver(sound);}
            if (arena.collectPowerUp()) {
                for (Monster monsterInArena: arena.getMonsters()) monsterInArena.setState(new ScaredState());
            }
        }

    }
}
