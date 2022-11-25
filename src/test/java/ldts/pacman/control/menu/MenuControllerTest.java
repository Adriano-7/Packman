package ldts.pacman.control.menu;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuControllerTest {
    MenuController menuController;
    @BeforeEach
    public void setUp() {
        Menu menu = new Menu();
        menuController = new MenuController(menu);
    }
}
