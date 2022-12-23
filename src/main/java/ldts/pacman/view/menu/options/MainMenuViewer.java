package ldts.pacman.view.menu.options;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.menu.options.MainMenu;

public class MainMenuViewer extends MenuViewer<MainMenu> {
    public MainMenuViewer(MainMenu menu, OptionsViewer optionsViewer) {
        super(menu, optionsViewer);
    }
    @Override
    protected void drawHeader(GUI gui) {
        gui.drawText(new Position(5, 7), "MAIN MENU", "#FFFFFF");
    }
}
