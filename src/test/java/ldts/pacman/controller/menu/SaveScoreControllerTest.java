package ldts.pacman.controller.menu;

import ldts.pacman.Game;
import ldts.pacman.application.state.MainMenuState;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.menu.SaveScore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;

public class SaveScoreControllerTest {
    private Game game;
    private SaveScoreController saveScoreController;
    private SaveScore saveScore;
    @BeforeEach
    public void setUp() {
        this.game = Mockito.mock(Game.class);
        this.saveScore = Mockito.mock(SaveScore.class);
        Mockito.when(saveScore.isSelectedSave()).thenReturn(false);
        this.saveScoreController = new SaveScoreController(saveScore);
    }
    public void getModel() {
        assertEquals(saveScore, saveScoreController.getModel());
    }


    @Test
    public void stepGoUp() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        saveScoreController.step(game, List.of(GUI.OPTION.UP), 0);
        Mockito.verify(saveScore, times(1)).prev_Op();
        Mockito.verifyNoInteractions(game);
    }
    @Test
    public void stepGoDown() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        saveScoreController.step(game, List.of(GUI.OPTION.DOWN), 0);

        Mockito.verify(saveScore, times(1)).next_Op();
        Mockito.verifyNoInteractions(game);
    }
    @Test
    public void stepWithQuit() {
        try {
            saveScoreController.step(game, Arrays.asList(GUI.OPTION.SELECT, GUI.OPTION.QUIT), 0);
        }
        catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            fail();
        }

        Mockito.verify(game, times(2))
                .setState(Mockito.any(MainMenuState.class));
        Mockito.verifyNoMoreInteractions(game);

        Mockito.verify(saveScore, times(1)).isSelectedSave();
        Mockito.verifyNoMoreInteractions(saveScore);
    }
    @Test
    public void stepNoQuit() {
        try {
            List<GUI.OPTION> options = Arrays.asList(GUI.OPTION.UP, GUI.OPTION.DOWN, GUI.OPTION.RIGHT, GUI.OPTION.LEFT);

            saveScoreController.step(game, options, 0);
        }
        catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            fail();
        }
        Mockito.verifyNoInteractions(game);
    }
    @Test
    public void stepDoNothing() {
        List<GUI.OPTION> options = Arrays.asList(GUI.OPTION.UP2, GUI.OPTION.DOWN2, GUI.OPTION.RIGHT2, GUI.OPTION.LEFT2);

        try {
            saveScoreController.step(game, options, 0);
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            fail();
        }
        Mockito.verifyNoInteractions(game);
        Mockito.verifyNoInteractions(saveScore);
    }
}
