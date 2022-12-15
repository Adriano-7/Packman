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

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

public class PacmanController extends GameController{
    private long lastMovement;
    private PlayerStrategy playerStrategy;
    SoundObserver soundPacCoin;
    SoundObserver soundPacDies;

    public PacmanController(Arena model) {
        super(model);
        playerStrategy = new PlayerStrategy();
        lastMovement = 0;
        soundPacCoin = new SoundPacCoin();
        soundPacDies = new SoundPacDies();
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
                playSingleSound(soundPacDies);
               }
            if(arena.collectCoin()){
                playSingleSound(soundPacCoin);
            }
            if (arena.collectPowerUp()) {
                for (Monster monsterInArena: arena.getMonsters()) monsterInArena.setState(new ScaredState());
            }
        }

    }
}
