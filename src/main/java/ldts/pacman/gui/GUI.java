package ldts.pacman.gui;

import ldts.pacman.model.game.Position;

import java.io.IOException;

public interface GUI {
    OPTION getNextOption() throws IOException;
    void drawPacman(Position position);
    void drawWall(Position position);
    void drawCoin(Position position);
    void drawText(Position position, String text, String color);
    void drawCharacter(Position position, char ch, String color);
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;
    enum OPTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}
