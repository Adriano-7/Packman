package ldts.pacman.controller.game;

import ldts.pacman.Game;
import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;

public class MonsterController extends GameController {
    private long lastMovement;
    public MonsterController(Arena model) {
        super(model);
        this.lastMovement = 0;
    }
    @Override
    public void step(Game game, GUI.OPTION option, long time) {
        if (time - lastMovement > 500 ) {
            for (Monster monster: getModel().getMonsters()) {
                MovementStrategy movementStrategy = monster.getMovementStrategy(getModel());
                movementStrategy.move(monster);
            }
            lastMovement = time;
        }
    }
}
