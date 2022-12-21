package ldts.pacman.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import ldts.pacman.model.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;

import static org.mockito.Mockito.times;

public class LanternaGUITest {
    private LanternaGUI gui;
    private Screen screen;
    private TextGraphics textGraphics;

    @BeforeEach
    public void setUp() throws IOException {
        screen = Mockito.mock(Screen.class);
        textGraphics = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(textGraphics);
        gui = new LanternaGUI(screen);
    }
    @Test
    public void testDrawPacman() {
        Position pacmanPos = new Position(2, 3);
        Position noDir = new Position(0, 0);
        Position upDir = new Position(0, -1);
        Position downDir = new Position(0, 1);
        Position rightDir = new Position(1, 0);
        Position leftDir = new Position(-1, 0);
        LanternaGUI guiSpy = Mockito.spy(gui);

        guiSpy.drawPacman(pacmanPos, noDir);
        verifyDrawPacman(pacmanPos, 'e', guiSpy);

        guiSpy.drawPacman(pacmanPos, upDir);
        verifyDrawPacman(pacmanPos, 'd', guiSpy);

        guiSpy.drawPacman(pacmanPos, downDir);
        verifyDrawPacman(pacmanPos, 'b', guiSpy);

        guiSpy.drawPacman(pacmanPos, rightDir);
        verifyDrawPacman(pacmanPos, 'a', guiSpy);

        guiSpy.drawPacman(pacmanPos, leftDir);
        verifyDrawPacman(pacmanPos, 'c', guiSpy);
    }
    private void verifyDrawPacman(Position pacmanPos, char c, LanternaGUI guiSpy) {
        String yellowColor = "#FFFF00";
        Mockito.verify(guiSpy, times(1)).drawCharacter(pacmanPos, c, yellowColor);
    }
    @Test
    public void testDrawWall(){
        LanternaGUI guiSpy = Mockito.spy(gui);
        Position wallPos = new Position(4, 5);

        guiSpy.drawWall(wallPos);

        Mockito.verify(guiSpy, times(1)).drawCharacter(wallPos, 'k', "#2424FF");
    }
    @Test
    public void testDrawCoin(){
        LanternaGUI guiSpy = Mockito.spy(gui);
        Position coinPos = new Position(2, 2);

        guiSpy.drawCoin(coinPos);

        Mockito.verify(guiSpy, times(1)).drawCharacter(coinPos, 'l', "#d4af37");
    }
    @Test
    public void testDrawText(){
        gui.drawText(new Position(2, 2), "Hello World", "#FF0000");
        Mockito.verify(textGraphics, times(1)).setForegroundColor(new TextColor.RGB(255, 0, 0));
        Mockito.verify(textGraphics, times(1)).putString(2, 2, "Hello World");
    }
    @Test
    public void testDrawCharacter(){
        int x = 2, y = 2;
        Position pos = new Position(x, y);
        gui.drawCharacter(pos, 'A', "#FF0000");
        Mockito.verify(textGraphics, times(1)).setForegroundColor(new TextColor.RGB(255, 0, 0));
        Mockito.verify(textGraphics, times(1)).putString(x, y, "A");
    }
    @Test
    public void testDrawScore(){
        Position scorePos = new Position(0, 22);
        int score = 100;
        String scoreStr = "SCORE: " + score;
        String color = "#FFFFFF";

        LanternaGUI guiSpy = Mockito.spy(gui);

        guiSpy.drawScore(100);
        Mockito.verify(guiSpy, times(1)).drawText(scorePos, scoreStr, color);
    }
    @Test
    public void testDrawHealth(){
        LanternaGUI guiSpy = Mockito.spy(gui);
        int health = 3;

        guiSpy.drawHealth(health);
        Mockito.verify(guiSpy, times(health)).drawCharacter(Mockito.any(Position.class), Mockito.anyChar(), Mockito.anyString());

        Mockito.clearInvocations(guiSpy);

        guiSpy.drawHealth(0);
        Mockito.verify(guiSpy, times(0)).drawCharacter(Mockito.any(Position.class), Mockito.anyChar(), Mockito.anyString());
    }
    @Test
    public void testDrawPowerUps(){
        LanternaGUI guiSpy = Mockito.spy(gui);
        Position powerUpPos = new Position(10, 5);

        guiSpy.drawPowerUp(powerUpPos);

        Mockito.verify(guiSpy, times(1)).drawCharacter(powerUpPos, 'j', "#ffffff");
    }
}
