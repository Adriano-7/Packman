package ldts.pacman.controller.menu;

import ldts.pacman.Game;
import ldts.pacman.gui.GUI;
import ldts.pacman.application.state.menu.MainMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ScoreMenuControllerTest {
    private Game game;
    private ScoreMenuController scoreMenuController;
    @BeforeEach
    public void setUp() {
        game = Mockito.mock(Game.class);
        scoreMenuController = new ScoreMenuController(null);
    }
    @Test
    public void stepNoQuit() {
        List<GUI.OPTION> options = Arrays.asList(GUI.OPTION.UP, GUI.OPTION.DOWN, GUI.OPTION.RIGHT, GUI.OPTION.LEFT,
                GUI.OPTION.UP2, GUI.OPTION.DOWN2, GUI.OPTION.RIGHT2, GUI.OPTION.LEFT2);

        scoreMenuController.step(game, options, 0);
        Mockito.verifyNoInteractions(game);
    }
    @Test
    public void stepSelectWithQuit() {
        scoreMenuController.step(game, List.of(GUI.OPTION.SELECT), 0);

        Mockito.verify(game, Mockito.times(1))
                .setState(Mockito.any(MainMenuState.class));
    }
    @Test
    public void stepWithQuit() {
        scoreMenuController.step(game, List.of(GUI.OPTION.QUIT), 0);

        Mockito.verify(game, Mockito.times(1))
                .setState(Mockito.any(MainMenuState.class));
    }
}
