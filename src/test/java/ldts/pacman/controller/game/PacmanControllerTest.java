package ldts.pacman.controller.game;

import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Coin;
import ldts.pacman.model.game.elements.Pacman;
import ldts.pacman.model.game.elements.Wall;
import ldts.pacman.model.game.elements.monsters.RedMonster;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import java.util.Arrays;

public class PacmanControllerTest {
    private PacmanController pacmanController;
    @BeforeEach
    public void setUp() {
        //Arena arena = null;
        //try {
            //arena = new Arena(10, 10);
        Arena arena = Mockito.mock(Arena.class);
        //} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
        //    fail();
        //}
        
        arena.setPacman(new Pacman(2, -1));
        arena.setCoins(Arrays.asList(new Coin(10, 10)));
        arena.setWalls(Arrays.asList(new Wall(7, 7)));
        arena.setMonsters(Arrays.asList(new RedMonster(9, 5)));
        this.pacmanController = new PacmanController(arena);
    }
    /*
    @Test
    public void stepNoMovement() {
        Pacman pacman = pacmanController.getModel().getPacman();
        Position initial = pacman.getPosition();

        pacmanController.step(null, GUI.OPTION.NONE, 1000);
        assertEquals(initial, pacman.getPosition());

        pacmanController.step(null, GUI.OPTION.UP, 200);
        assertEquals(initial, pacman.getPosition());

        pacmanController.step(null, GUI.OPTION.LEFT, -1000);
        assertEquals(initial, pacman.getPosition());
    }


    @Test
    public void stepWithMovement() {
        Pacman pacman = pacmanController.getModel().getPacman();
        Position initial = pacman.getPosition();

        // TODO: fix error in test (known error because of how way direction works)
        // Direction doesn't start at (0, 0) but at (1, 0)
        pacmanController.step(null, GUI.OPTION.UP, 501);
        assertEquals(initial.getUp(), pacman.getPosition());

        pacmanController.step(null, GUI.OPTION.NONE, 1002);
        assertEquals(initial.getUp().getUp(), pacman.getPosition());

    }
    @Test
    public void stepTimeTesting() {
        Pacman pacman = pacmanController.getModel().getPacman();
        Position initial = pacman.getPosition();

        // TODO: fix error in test (known error because of the way direction works)
        // Direction doesn't start at (0, 0) but at (1, 0)
        pacmanController.step(null, GUI.OPTION.NONE, 1000);
        assertEquals(initial, pacman.getPosition());

        pacmanController.step(null, GUI.OPTION.DOWN, 501);
        assertEquals(initial.getDown(), pacman.getPosition());
    }
    */
}
