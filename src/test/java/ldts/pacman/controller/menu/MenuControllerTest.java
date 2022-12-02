package ldts.pacman.controller.menu;

import ldts.pacman.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;

public class MenuControllerTest {
    MenuController menuController;
    @BeforeEach
    public void setUp() {
        Menu menu = new Menu();
        menuController = new MenuController(menu);
    }
}
