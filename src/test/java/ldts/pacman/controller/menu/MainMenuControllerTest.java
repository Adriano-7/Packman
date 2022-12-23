package ldts.pacman.controller.menu;

import ldts.pacman.Game;
import ldts.pacman.application.state.menu.ChooseLevelState;
import ldts.pacman.application.state.menu.ScoreMenuState;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.menu.options.MainMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class MainMenuControllerTest {
    private MainMenuController mainMenuController;
    private MainMenu mainMenu;
    @BeforeEach
    public void setUp() {
        this.mainMenu = Mockito.mock(MainMenu.class);
        this.mainMenuController = new MainMenuController(mainMenu);
    }
    @Test
    public void getModel() {
        assertEquals(mainMenu, mainMenuController.getModel());
    }
    private void stepMainMenuController(Game game, List<GUI.OPTION> options) {
        try {
            mainMenuController.step(game, options, 0);
        }
        catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            fail();
        }
    }
    @Test
    public void stepUp() {
        stepMainMenuController(null, List.of(GUI.OPTION.UP));
        try {
            verify(mainMenu, times(1)).prev_Op();
        }
        catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            fail();
        }

    }
    @Test
    public void stepDown() {
        stepMainMenuController(null, List.of(GUI.OPTION.DOWN));
        try {
            verify(mainMenu, times(1)).next_Op();
        }
        catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            fail();
        }
    }
    @Test
    public void stepNone() {
        stepMainMenuController(null, List.of(GUI.OPTION.UP2));
        stepMainMenuController(null, List.of(GUI.OPTION.DOWN2));
        stepMainMenuController(null, List.of(GUI.OPTION.RIGHT2));
        stepMainMenuController(null, List.of(GUI.OPTION.LEFT2));
        verifyNoInteractions(mainMenu);
    }
    private Game mockGame() {
        return Mockito.mock(Game.class);
    }
    private void allReturnFalse(MainMenu mainMenu) {
        Mockito.when(mainMenu.isSelectedExit()).thenReturn(false);
        Mockito.when(mainMenu.isSelectedStartSingle()).thenReturn(false);
        Mockito.when(mainMenu.isSelectedStartMulti()).thenReturn(false);
        Mockito.when(mainMenu.isSelectedScores()).thenReturn(false);
    }
    @Test
    public void stepSelectExit() {
        Game game = mockGame();

        allReturnFalse(mainMenu);
        Mockito.when(mainMenu.isSelectedExit()).thenReturn(true);

        stepMainMenuController(game, List.of(GUI.OPTION.SELECT));

        verify(mainMenu, times(1)).isSelectedExit();
        verify(game, times(1)).setState(null);
    }
    @Test
    public void stepSelectStartSingle() {
        Game game = mockGame();

        allReturnFalse(mainMenu);
        Mockito.when(mainMenu.isSelectedStartSingle()).thenReturn(true);

        stepMainMenuController(game, List.of(GUI.OPTION.SELECT));

        verify(mainMenu, times(1)).isSelectedStartSingle();
        verify(game, times(1)).setState(any(ChooseLevelState.class));
    }
    @Test
    public void stepSelectStartMulti() {
        Game game = mockGame();

        allReturnFalse(mainMenu);
        Mockito.when(mainMenu.isSelectedStartMulti()).thenReturn(true);

        stepMainMenuController(game, List.of(GUI.OPTION.SELECT));

        verify(mainMenu, times(1)).isSelectedStartMulti();
        verify(game, times(1)).setState(any(ChooseLevelState.class));
    }
    @Test
    public void stepSelectScores() {
        Game game = mockGame();

        allReturnFalse(mainMenu);
        Mockito.when(mainMenu.isSelectedScores()).thenReturn(true);

        stepMainMenuController(game, List.of(GUI.OPTION.SELECT));

        verify(mainMenu, times(1)).isSelectedScores();
        verify(game, times(1)).setState(any(ScoreMenuState.class));
    }
}
