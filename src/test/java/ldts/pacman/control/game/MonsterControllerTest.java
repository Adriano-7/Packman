package ldts.pacman.control.game;

import ldts.pacman.control.game.MonsterController;
import ldts.pacman.control.game.PacmanController;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.Pacman;
import ldts.pacman.model.game.elements.monsters.BlueMonster;
import ldts.pacman.model.game.elements.monsters.RedMonster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Use jUnit and Mockito to test the MonsterController class
public class MonsterControllerTest {
    private MonsterController monsterController;
    @BeforeEach
    public void setUp() {
        Arena arena = Mockito.mock(Arena.class);
        Mockito.when(arena.getMonsters()).thenReturn(Arrays.asList(new RedMonster(5, 5)));
        Mockito.when(arena.isWall(Mockito.any())).thenReturn(false);
        Mockito.when(arena.getPacman()).thenReturn(new Pacman(0, 0));
        this.monsterController = new MonsterController(arena);
    }
    @Test
    public void stepAllMonstersMove() {
        monsterController.step(null, null, 700);
        assertFalse(monsterController.getModel().getMonsters().get(0).getPosition().equals(new Position(5, 5)));
    }
    @Test
    public void stepAllMonstersDontMove() {
        monsterController.step(null, null, 400);
        assertTrue(monsterController.getModel().getMonsters().get(0).getPosition().equals(new Position(5, 5)));
    }
}