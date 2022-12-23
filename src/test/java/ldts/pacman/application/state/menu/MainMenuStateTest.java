package ldts.pacman.application.state.menu;

import ldts.pacman.controller.menu.MainMenuController;
import ldts.pacman.model.menu.options.MainMenu;
import ldts.pacman.view.menu.options.MainMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainMenuStateTest {
    private MainMenu mainMenu;
    private MainMenuState mainMenuState;
    @BeforeEach
    public void setUp() {
        mainMenu = Mockito.mock(MainMenu.class);
        mainMenuState = new MainMenuState(mainMenu);
    }
    @Test
    public void getModel() {
        assertEquals(mainMenu, mainMenuState.getModel());
    }
    @Test
    public void getViewer(){
        assertEquals(MainMenuViewer.class, mainMenuState.getViewer().getClass());
    }
    @Test
    public void getController(){
        assertEquals(MainMenuController.class, mainMenuState.getController().getClass());
    }
}
