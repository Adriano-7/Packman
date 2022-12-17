package ldts.pacman.controller.game.movement.strategy.player;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.Pacman;
import ldts.pacman.model.game.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;

public class PacmanStrategyTest {

    private PacmanStrategy pacmanStrategy;
    private Pacman pacman;
    // private Arena arena;

    @BeforeEach
    public void setUp() {
        // this.arena = Mockito.mock(Arena.class);
        this.pacman = Mockito.mock(Pacman.class);
        this.pacmanStrategy = new PacmanStrategy();
    }
    @Test
    public void changeDirectionNone() {
        List<GUI.OPTION> noneOptions = Arrays.asList(GUI.OPTION.DOWN2, GUI.OPTION.UP2, GUI.OPTION.LEFT2,
                GUI.OPTION.RIGHT2, GUI.OPTION.SELECT, GUI.OPTION.QUIT);

        pacmanStrategy.changeDirection(noneOptions, pacman);

        Mockito.verifyNoInteractions(pacman);
    }
    @Test
    public void changeDirection() {
        GUI.OPTION[] options = { GUI.OPTION.DOWN, GUI.OPTION.UP, GUI.OPTION.LEFT, GUI.OPTION.RIGHT };
        Position[] correspondingDirections = { new Position(0, 1), new Position(0, -1), new Position(-1, 0), new Position(1, 0) };

        boolean precondition = options.length == correspondingDirections.length;
        assertTrue(precondition);

        int arraySize = options.length;
        for (int i = 0; i < arraySize; i++) {
            pacmanStrategy.changeDirection(List.of(options[i]), pacman);
            Mockito.verify(pacman, times(1)).setDirection(correspondingDirections[i]);
            Mockito.verifyNoMoreInteractions(pacman);
        }
    }
}
