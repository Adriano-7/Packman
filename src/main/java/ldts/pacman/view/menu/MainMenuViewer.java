package ldts.pacman.view.menu;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.menu.MainMenu;
import ldts.pacman.view.Viewer;

public class MainMenuViewer extends MenuViewer<MainMenu> {
    public MainMenuViewer(MainMenu menu, OptionsViewer optionsViewer) {
        super(menu, optionsViewer);
    }
    @Override
    protected void drawHeader(GUI gui) {
        gui.drawText(new Position(5, 7), "MAIN MENU", "#FFFFFF");
    }
}
