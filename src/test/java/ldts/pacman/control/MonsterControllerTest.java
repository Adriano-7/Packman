package ldts.pacman.control;

import ldts.pacman.control.game.MonsterController;
import ldts.pacman.control.game.PacmanController;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.Pacman;
import ldts.pacman.model.game.elements.monsters.BlueMonster;
import ldts.pacman.model.game.elements.monsters.RedMonster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class MonsterControllerTest {
    private MonsterController monsterController;
    @BeforeEach
    public void setUp() {
        Arena arena = new Arena(10, 10);
        arena.setPacman(new Pacman(4, -1));
        List<Monster> monsters = Arrays.asList(new RedMonster(5, 5), new BlueMonster(7, 7));
        arena.setMonsters(monsters);
        this.monsterController = new MonsterController(arena);
    }
    @Test
    public void stepNoMovement() {
        /*
        for (Monster monster: monsterController.getModel().getMonsters()) {

        }
        monsterController.step(null, null, 0);
        for (Monster monster: monsterController.getModel().getMonsters()) {
            //assertEquals(expected, monster.getPosition());
        }
        */
    }
}
