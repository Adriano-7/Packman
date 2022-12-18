package ldts.pacman.application.state;

import ldts.pacman.controller.menu.ScoreMenuController;
import ldts.pacman.model.menu.ScoreMenu;
import ldts.pacman.view.menu.ScoreMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class ScoreMenuStateTest {
    private ScoreMenuState scoreMenuState;
    private ScoreMenu scoreMenu;
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
}
