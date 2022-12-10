package ldts.pacman.view.menu;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.menu.MainMenu;
import ldts.pacman.model.menu.Menu;
import ldts.pacman.view.Viewer;

import java.io.IOException;


public class MainMenuViewer extends Viewer<MainMenu> {
    private final OptionsViewer optionsViewer;
    public MainMenuViewer(MainMenu menu, OptionsViewer optionsViewer) {
        super(menu);
        this.optionsViewer = optionsViewer;
    }
    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "PACMAN", "#FFFFFF");
        optionsViewer.drawOptions(gui);
    }
}
