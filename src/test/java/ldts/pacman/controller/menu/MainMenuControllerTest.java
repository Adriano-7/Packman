package ldts.pacman.controller.menu;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.menu.MainMenu;
import ldts.pacman.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MainMenuControllerTest {
    private MainMenuController mainMenuController;
    private MainMenu mainMenu;
    @BeforeEach
    public void setUp() {
        this.mainMenu = new MainMenu();
        this.mainMenuController = new MainMenuController(mainMenu);

        assertEquals(mainMenu, mainMenuController.getModel());
    }
    public void stepUp() {
        int expectedOption = mainMenu.getCurrentOption();
        try {
            mainMenuController.step(null, Arrays.asList(GUI.OPTION.UP), 0);
        }
        catch (IOException e) {
            fail();
        }


    }
    public void stepDown() {
        // TODO
    }
    public void stepEnter() {
        // TODO
    }
}
