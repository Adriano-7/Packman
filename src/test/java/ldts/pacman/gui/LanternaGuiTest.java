package ldts.pacman.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import ldts.pacman.model.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LanternaGuiTest {
    private LanternaGUI gui;
    private Screen screen;
    private TextGraphics textGraphics;

    @BeforeEach
    public void setUp() {
        screen = Mockito.mock(Screen.class);
        textGraphics = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(textGraphics);
        gui = new LanternaGUI(screen);
    }


    @Test
    public void drawPacman() {
        gui.drawPacman(new Position(2,3));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(2, 3, "@");
    }

    @Test
    public void drawWall(){
        gui.drawWall(new Position(4, 5));
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(4, 5, "|");
    }

    @Test
    public void drawCoin(){
        gui.drawCoin(new Position(2, 2));
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(212, 175, 55));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(2, 2, "o");
    }

}
