package ldts.packman.gui;

import ldts.packman.model.game.Position;

import java.io.IOException;

public interface GUI {
    enum OPTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
    OPTION getNextOption() throws IOException;

    void drawText(Position position, String text, String color);
    void clear();
    void refresh();
    void close();
}
