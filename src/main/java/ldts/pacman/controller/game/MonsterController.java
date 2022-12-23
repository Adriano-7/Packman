package ldts.pacman.controller.game;

import ldts.pacman.Game;
import ldts.pacman.controller.game.monster.state.MonsterState;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.monsters.Monster;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

public class MonsterController extends GameController {
    public MonsterController(Arena model) {
        super(model);
    }
    @Override
    public void step(Game game, List<GUI.OPTION> options, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        for (Monster monster: getModel().getMonsters()) {
            MonsterState monsterState = monster.getState();
            if (monsterState.move(monster, getModel(), options, time) && getModel().collidesWithPacman(monster)) {
                monster.getHit(getModel());
            }
        }
    }
}
