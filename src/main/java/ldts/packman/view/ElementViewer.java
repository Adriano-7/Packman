package ldts.packman.view;

import ldts.packman.gui.GUI;
import ldts.packman.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
