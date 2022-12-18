package ldts.pacman.view.menu;

import ldts.pacman.gui.GUI;
import ldts.pacman.view.Viewer;

abstract class MenuViewer<T> extends Viewer<T> {
    private final OptionsViewer optionsViewer;
    public MenuViewer(T model, OptionsViewer optionsViewer) {
        super(model);
        this.optionsViewer = optionsViewer;
    }
    protected abstract void drawHeader(GUI gui);
    @Override
    protected void drawElements(GUI gui) {
        drawHeader(gui);
        optionsViewer.drawOptions(gui);
    }
}
