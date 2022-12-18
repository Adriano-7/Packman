package ldts.pacman.controller.game;

import ldts.pacman.Game;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Pacman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ArenaControllerTest {
    private Arena arena;
    private ArenaController arenaController;
    @BeforeEach
    public void setUp() {
        this.arena = Mockito.mock(Arena.class);

        arenaController = new ArenaController(arena);
    }

    /*
    @Test
    public void quitGame() {
        Game game = Mockito.mock(Game.class);
        try {
            arenaController.step(game, GUI.OPTION.QUIT, 0);
            Mockito.verify(game, Mockito.times(1))
                    .setState(Mockito.any(SaveScoreState.class));
        }
        catch (IOException e) {
            fail();
        }
    }
    */

    @Test
    public void stepZeroHealth() {
        Pacman pacman = Mockito.mock(Pacman.class);
        arenaController.getModel().setPacman(pacman);

        Mockito.when(pacman.getHealth()).thenReturn(0);
        Game game = Mockito.mock(Game.class);
        /*
        try {
            //arenaController.step(game, null, 0);
        }
        catch (IOException e) {
            fail();
        }
        */

        //Mockito.verify(game, Mockito.times(1))
        //        .setState(Mockito.any(SaveScoreState.class));
    }
}
