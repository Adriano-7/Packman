package ldts.pacman.controller.menu;

import ldts.pacman.Game;
import ldts.pacman.gui.GUI;
import ldts.pacman.application.state.MainMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ScoreMenuControllerTest {
    private Game game;
    private ScoreMenuController scoreMenuController;
    @BeforeEach
    public void setUp() {
        game = Mockito.mock(Game.class);
        scoreMenuController = new ScoreMenuController(null);
    }
    /*
    @Test
    public void stepNoQuit() {
        scoreMenuController.step(game, GUI.OPTION.NONE, 0);
        scoreMenuController.step(game, GUI.OPTION.UP, 0);
        scoreMenuController.step(game, GUI.OPTION.DOWN, 0);
        scoreMenuController.step(game, GUI.OPTION.RIGHT, 0);
        scoreMenuController.step(game, GUI.OPTION.LEFT, 0);

        Mockito.verifyNoInteractions(game);
    }
    @Test
    public void stepWithQuit() {
        scoreMenuController.step(game, GUI.OPTION.SELECT, 0);
        scoreMenuController.step(game, GUI.OPTION.QUIT, 0);

        Mockito.verify(game, Mockito.times(2))
                .setState(Mockito.any(MainMenuState.class));
    }
    */
}
