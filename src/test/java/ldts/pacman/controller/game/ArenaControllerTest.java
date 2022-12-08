package ldts.pacman.controller.game;

import ldts.pacman.Game;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Pacman;
import ldts.pacman.applicationState.SaveScoreState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ArenaControllerTest {
    ArenaController arenaController;
    @BeforeEach
    public void setUp() {
        Arena arena = new Arena(10, 10);
        arenaController = new ArenaController(arena);
    }

    @Test
    public void quitGame() {
        Game game = Mockito.mock(Game.class);
        arenaController.step(game, GUI.OPTION.QUIT, 0);
        Mockito.verify(game, Mockito.times(1))
                .setState(Mockito.any(SaveScoreState.class));
    }

    @Test
    public void stepZeroHealth() {
        Pacman pacman = Mockito.mock(Pacman.class);
        arenaController.getModel().setPacman(pacman);

        Mockito.when(pacman.getHealth()).thenReturn(0);
        Game game = Mockito.mock(Game.class);

        arenaController.step(game, null, 0);

        Mockito.verify(game, Mockito.times(1))
                .setState(Mockito.any(SaveScoreState.class));
    }
}
