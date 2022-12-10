package ldts.pacman.controller.menu;

import ldts.pacman.model.menu.MainMenu;
import ldts.pacman.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;

public class MainMenuControllerTest {
    MainMenuController mainMenuController;
    @BeforeEach
    public void setUp() {
        MainMenu mainMenu = new MainMenu();
        mainMenuController = new MainMenuController(mainMenu);
    }
}
