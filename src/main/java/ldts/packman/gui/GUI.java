package ldts.packman.gui;

import ldts.packman.model.game.Position;
import ldts.packman.model.game.elements.Pacman;
import ldts.packman.model.game.elements.Wall;

import java.io.IOException;

public interface GUI {
    OPTION getNextOption() throws IOException;
    void drawPacman(Pacman pacman, Position position);
    void drawWall(Wall wall, Position position);
    void drawText(Position position, String text, String color);
    void drawCharacter(int x, int y, char ch, String color);
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;
    enum OPTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}
