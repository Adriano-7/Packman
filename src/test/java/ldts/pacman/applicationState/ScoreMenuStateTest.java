package ldts.pacman.applicationState;

import ldts.pacman.controller.menu.ScoreMenuController;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.menu.ScoreMenu;
import ldts.pacman.view.menu.ScoreMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

public class ScoreMenuStateTest {
    public ScoreMenuState scoreMenuState;
    public ScoreMenu scoreMenu;
    @BeforeEach
    public void setUp() {
        try { scoreMenu = new ScoreMenu(); }
        catch (IOException e) { fail(); }
        scoreMenuState = new ScoreMenuState(scoreMenu);
    }
    @Test
    public void getModel(){
        assertEquals(scoreMenu, scoreMenuState.getModel());
    }
    @Test
    public void getViewer(){
        assertEquals(ScoreMenuViewer.class, scoreMenuState.getViewer().getClass());
    }
    @Test
    public void getController(){
        assertEquals(ScoreMenuController.class, scoreMenuState.getController().getClass());
    }
    @Test
    public void step() throws IOException {
        GUI gui = Mockito.mock(GUI.class);

        scoreMenuState.step(null, gui, 0);

        Mockito.verify(gui, times(1)).getNextOption();
    }
}
