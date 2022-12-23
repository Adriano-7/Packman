package ldts.pacman.application.state.menu;

import ldts.pacman.controller.menu.SaveScoreController;
import ldts.pacman.model.menu.options.SaveScore;
import ldts.pacman.view.menu.options.SaveScoreViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveScoreStateTest {
    private SaveScore saveScore;
    private SaveScoreState saveScoreState;
    @BeforeEach
    public void setUp() {
        this.saveScore = Mockito.mock(SaveScore.class);
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
