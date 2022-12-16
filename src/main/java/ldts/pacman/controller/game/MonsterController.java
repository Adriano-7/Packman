package ldts.pacman.controller.game;

import ldts.pacman.Game;
import ldts.pacman.controller.game.monster.state.MonsterState;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.sound.observer.SoundObserver;
import ldts.pacman.sound.observer.SoundPacDies;
import java.io.IOException;
import java.util.List;

public class MonsterController extends GameController {
    public MonsterController(Arena model) {
        super(model);
        soundPacDies = new SoundPacDies();
    }
    SoundObserver soundPacDies;
    @Override
    public void step(Game game, List<GUI.OPTION> options, long time) throws IOException {
        for (Monster monster: getModel().getMonsters()) {
            MonsterState monsterState = monster.getState();
            if (monsterState.move(monster, getModel(), options, time) && monster.collidesWithPacman(getModel().getPacman())) {
                monster.getHit(getModel());
            }
        }
    }
}
