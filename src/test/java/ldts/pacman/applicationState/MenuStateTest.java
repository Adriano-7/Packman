package ldts.pacman.applicationState;

import ldts.pacman.controller.menu.MenuController;
import ldts.pacman.model.menu.Menu;
import ldts.pacman.view.menu.MenuViewer;
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
    public void getModel() {
        assertEquals(menu, menuState.getModel());
    }
    @Test
    public void getViewer(){
        assertEquals(MenuViewer.class, menuState.getViewer().getClass());
    }
    @Test
    public void getController(){
        assertEquals(MenuController.class, menuState.getController().getClass());
    }
}
