package ldts.pacman.controller.menu;

import ldts.pacman.Game;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.menu.ScoreMenu;
import ldts.pacman.state.MenuState;
import ldts.pacman.state.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ScoreMenuControllerTest {
    Game game;
    @BeforeEach
    public void setUp() {
        game = Mockito.mock(Game.class);
    }
    @Test
    public void stepNoQuit() {
        ScoreMenuController scoreMenuController = new ScoreMenuController(null);

        scoreMenuController.step(game, GUI.OPTION.NONE, 0);
        scoreMenuController.step(game, GUI.OPTION.UP, 0);
        scoreMenuController.step(game, GUI.OPTION.DOWN, 0);
        scoreMenuController.step(game, GUI.OPTION.RIGHT, 0);
        scoreMenuController.step(game, GUI.OPTION.LEFT, 0);

        Mockito.verifyNoInteractions(game);
    }
    @Test
    public void stepWithQuit() {
        ScoreMenuController scoreMenuController = new ScoreMenuController(null);

        scoreMenuController.step(game, GUI.OPTION.SELECT, 0);
        scoreMenuController.step(game, GUI.OPTION.QUIT, 0);

        Mockito.verify(game, Mockito.times(2))
                .setState(Mockito.any(MenuState.class));
    }
}
