package ldts.pacman.control;


import ldts.pacman.control.game.PacmanController;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Coin;
import ldts.pacman.model.game.elements.Pacman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PacmanControllerTest {
    PacmanController pacmanController;
    @BeforeEach
    public void setUp() {
        Arena arena = new Arena(10, 10);
        arena.setPacman(new Pacman(4, -1));
        arena.setCoins(Arrays.asList(new Coin(10, 10)));
        this.pacmanController = new PacmanController(arena);
    }
    @Test
    public void stepNoMovement() {
        Pacman pacman = pacmanController.getModel().getPacman();
        Position initial = pacman.getPosition();

        pacmanController.step(null, GUI.OPTION.NONE, 1000);
        assertEquals(initial, pacman.getPosition());

        pacmanController.step(null, GUI.OPTION.UP, 500);
        assertEquals(initial, pacman.getPosition());

        pacmanController.step(null, GUI.OPTION.LEFT, -1000);
        assertEquals(initial, pacman.getPosition());
    }
    @Test
    public void stepWithMovement() {
        Pacman pacman = pacmanController.getModel().getPacman();
        Position initial = pacman.getPosition();

        pacmanController.step(null, GUI.OPTION.UP, 501);
        assertEquals(initial.getUp(), pacman.getPosition());

        pacmanController.step(null, GUI.OPTION.NONE, 1002);
        assertEquals(initial.getUp().getUp(), pacman.getPosition());

    }
    @Test
    public void stepTimeTesting() {
        Pacman pacman = pacmanController.getModel().getPacman();
        Position initial = pacman.getPosition();

        pacmanController.step(null, GUI.OPTION.NONE, 1000);
        assertEquals(initial, pacman.getPosition());
        // assertEquals(pacman.getLastMovement(), 0);

        pacmanController.step(null, GUI.OPTION.DOWN, 501);
        assertEquals(initial.getDown(), pacman.getPosition());
    }
    @Test
    public void stepCollectCoin() {

    }
}
