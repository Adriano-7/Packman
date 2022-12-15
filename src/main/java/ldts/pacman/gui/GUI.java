package ldts.pacman.gui;

import ldts.pacman.controller.game.monster.state.MonsterState;
import ldts.pacman.model.game.Position;

import java.io.IOException;
import java.util.List;

public interface GUI {
    List<OPTION> getNextOptions() throws IOException;
    void drawPacman(Position position, Position direction);
    void drawWall(Position position);
    void drawCoin(Position position);
    void drawMonster(Position position, Position direction, MonsterState state);
    void drawScore(int score);
    void drawHealth(int health);
    void drawPowerUp(Position position);
    void drawText(Position position, String text, String color);
    void drawCharacter(Position position, char ch, String color);
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;
    enum OPTION {UP, RIGHT, DOWN, LEFT, QUIT, SELECT, UP2, RIGHT2, DOWN2, LEFT2}
}
