package ldts.pacman.controller.menu;

import ldts.pacman.Game;
import ldts.pacman.application.state.MainMenuState;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.menu.SaveScore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

public class SaveScoreControllerTest {
    Game game;
    SaveScoreController saveScoreController;
    @BeforeEach
    public void setUp() {
        game = Mockito.mock(Game.class);
        SaveScore saveScore = new SaveScore(5);
        saveScoreController = new SaveScoreController(saveScore);
    }
    @Test
    public void stepNoQuit() {
        try {
            saveScoreController.step(game, GUI.OPTION.NONE, 0);
            saveScoreController.step(game, GUI.OPTION.UP, 0);
            saveScoreController.step(game, GUI.OPTION.DOWN, 0);
            saveScoreController.step(game, GUI.OPTION.RIGHT, 0);
            saveScoreController.step(game, GUI.OPTION.LEFT, 0);
        }
        catch (IOException e) {
            fail();
        }

        Mockito.verifyNoInteractions(game);
    }
    @Test
    public void stepWithQuit() {
        try {
            saveScoreController.step(game, GUI.OPTION.SELECT, 0);
            saveScoreController.step(game, GUI.OPTION.QUIT, 0);
        }
        catch (IOException e) {
            fail();
        }

        Mockito.verify(game, Mockito.times(2))
                .setState(Mockito.any(MainMenuState.class));
    }
}
