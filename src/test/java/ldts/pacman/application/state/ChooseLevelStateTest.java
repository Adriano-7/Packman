package ldts.pacman.application.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import ldts.pacman.controller.menu.ChooseLevelController;
import ldts.pacman.view.menu.ChooseLevelViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ldts.pacman.model.menu.ChooseLevel;

public class ChooseLevelStateTest {
    ChooseLevel chooseLevel;
    ChooseLevelState chooseLevelState;
    @BeforeEach
    public void setUp(){
        chooseLevel = Mockito.mock(ChooseLevel.class);
        chooseLevelState = new ChooseLevelState(chooseLevel);
    }
    @Test
    public void getModel(){
        assertEquals(chooseLevel, chooseLevelState.getModel());
    }
    @Test
    public void getViewer(){
        assertEquals(ChooseLevelViewer.class, chooseLevelState.getViewer().getClass());
    }
    @Test
    public void getController(){
        assertEquals(ChooseLevelController.class, chooseLevelState.getController().getClass());
    }
}