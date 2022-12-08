package ldts.pacman.applicationState;

import ldts.pacman.controller.menu.SaveScoreController;
import ldts.pacman.model.menu.SaveScore;
import ldts.pacman.view.menu.SaveScoreViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveScoreStateTest {
    SaveScore saveScore;
    SaveScoreState saveScoreState;
    @BeforeEach
    public void setUp() {
        saveScore = new SaveScore(100);
        saveScoreState = new SaveScoreState(saveScore);
    }
    @Test
    public void getModel() {
        assertEquals(saveScore, saveScoreState.getModel());
    }
    @Test
    public void getViewer(){
        assertEquals(SaveScoreViewer.class, saveScoreState.getViewer().getClass());
    }
    @Test
    public void getController(){
        assertEquals(SaveScoreController.class, saveScoreState.getController().getClass());
    }
}
