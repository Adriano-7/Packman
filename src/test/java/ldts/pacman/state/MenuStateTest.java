package ldts.pacman.state;

import ldts.pacman.model.menu.Menu;
import ldts.pacman.model.menu.MenuTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuStateTest {
    Menu menu;
    MenuState menuState;

    @BeforeEach
    public void setUp() {
        menu = new Menu();
        menuState = new MenuState(menu);
    }
    @Test
    public void testGetModel() {
        assertEquals(menu, menuState.getModel());
    }
}
