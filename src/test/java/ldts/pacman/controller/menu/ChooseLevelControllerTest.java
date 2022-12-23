package ldts.pacman.controller.menu;

import ldts.pacman.Game;
import ldts.pacman.application.state.GameState;
import ldts.pacman.application.state.menu.MainMenuState;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.ArenaLoader;
import ldts.pacman.model.menu.options.ChooseLevel;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

public class ChooseLevelControllerTest {
    private ChooseLevel chooseLevel;
    private ChooseLevelController chooseLevelController;
    @BeforeEach
    public void setUp() {
        this.chooseLevel = Mockito.mock(ChooseLevel.class);
        this.chooseLevelController = new ChooseLevelController(chooseLevel);
    }
    private Game mockGame() {
        return Mockito.mock(Game.class);
    }
    @Test
    public void getModel() {
        assertEquals(chooseLevel, chooseLevelController.getModel());
    }
    @Test
    public void stepUpDownQuit() {
        Game game = mockGame();
        try {
            chooseLevelController.step(game, Arrays.asList(GUI.OPTION.UP, GUI.OPTION.DOWN, GUI.OPTION.QUIT), 0);
            Mockito.verify(chooseLevel, times(1)).next_Op();
            Mockito.verify(chooseLevel, times(1)).prev_Op();
        }
        catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            fail();
        }

        Mockito.verify(game, times(1)).setState(any(MainMenuState.class));
    }
    @Test
    public void stepSelectExit() {
        Game game = mockGame();
        Mockito.when(chooseLevel.isSelectedExit()).thenReturn(true);

        try {
            chooseLevelController.step(game, List.of(GUI.OPTION.SELECT), 0);
        }
        catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            fail();
        }
        Mockito.verify(chooseLevel, times(1)).isSelectedExit();
        Mockito.verifyNoMoreInteractions(chooseLevel);
        Mockito.verify(game, times(1)).setState(any(MainMenuState.class));
    }
    @Test
    public void stepSelectLevel() {
        Game game = mockGame();
        Mockito.when(chooseLevel.isSelectedExit()).thenReturn(false);
        ArenaLoader arenaLoader = Mockito.mock(ArenaLoader.class);
        Mockito.when(chooseLevel.getArenaLoader()).thenReturn(arenaLoader);
        try {
            chooseLevelController.step(game, List.of(GUI.OPTION.SELECT), 0);

            Mockito.verify(arenaLoader, times(1)).createArena(Mockito.any(), Mockito.any(), Mockito.any());
        }
        catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            fail();
        }

        Mockito.verify(chooseLevel, times(1)).isSelectedExit();
        Mockito.verify(game, times(1)).setState(any(GameState.class));
    }

}
