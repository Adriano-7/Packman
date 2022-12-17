package ldts.pacman.view.menu;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.menu.Menu;

public class OptionsViewer {
    private final Menu menu;
    public OptionsViewer(Menu menu) {
        this.menu = menu;
    }
    public void drawOptions(GUI gui) {
        for (int i = 0; i < menu.getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 7 + i),
                    menu.getOption(i),
                    menu.isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
