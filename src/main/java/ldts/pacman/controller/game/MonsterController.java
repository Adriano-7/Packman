package ldts.pacman.controller.game;

import ldts.pacman.Game;
import ldts.pacman.controller.game.monster.state.MonsterState;
import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;

import java.util.List;

public class MonsterController extends GameController {
    public MonsterController(Arena model) {
        super(model);
    }
    @Override
    public void step(Game game, List<GUI.OPTION> options, long time) {
        for (Monster monster: getModel().getMonsters()) {
            MonsterState monsterState = monster.getState();
            if (monsterState.move(monster, getModel(), time) &&
                    monster.collidesWithPacman(getModel().getPacman())) {
                monster.getHit(getModel());
            }
        }
    }
}
