package ldts.pacman.application.state;

import ldts.pacman.controller.menu.MainMenuController;
import ldts.pacman.model.menu.MainMenu;
import ldts.pacman.view.menu.MainMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainMenuStateTest {
    private MainMenu mainMenu;
    private MainMenuState mainMenuState;
    @BeforeEach
    public void setUp() {
        mainMenu = new MainMenu();
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
