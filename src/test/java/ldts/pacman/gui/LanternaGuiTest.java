package ldts.pacman.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.elements.PowerUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanternaGuiTest {
    private LanternaGUI gui;
    private Screen screen;
    private TextGraphics textGraphics;

    @BeforeEach
    public void setUp() throws IOException {
        screen = Mockito.mock(Screen.class);
        textGraphics = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowUp));
        Mockito.when(screen.newTextGraphics()).thenReturn(textGraphics);
        gui = new LanternaGUI(screen);
    }
    /*
    @Test
    public void testGetNextOption() throws IOException {
        assertEquals(gui.getNextOption(), GUI.OPTION.UP);
    }

     */
    /*
    public void testDrawPacman() {
        gui.drawPacman(new Position(2,3), );

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(2, 3, "@");
    }
    */

    @Test
    public void testDrawWall(){
        gui.drawWall(new Position(4, 5));
        //Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(36, 36, 255));
        //Mockito.verify(textGraphics, Mockito.times(1)).putString(4, 5, "#");
    }
    @Test
    public void testDrawCoin(){
        gui.drawCoin(new Position(2, 2));
        //Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(212, 175, 55));
        //Mockito.verify(textGraphics, Mockito.times(1)).putString(2, 2, "o");
    }
    /*
    @Test
    public void testDrawMonster(){
        gui.drawMonster(new Position(2, 2), "#FF0000");
        //Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 0, 0));
        //Mockito.verify(textGraphics, Mockito.times(1)).putString(2, 2, "M");
    }
    */
    @Test
    public void testDrawText(){
        gui.drawText(new Position(2, 2), "Hello World", "#FF0000");
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 0, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(2, 2, "Hello World");
    }
    @Test
    public void testDrawCharacter(){
        gui.drawCharacter(new Position(2, 2), 'A', "#FF0000");
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 0, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(2, 2, "A");
    }
    @Test
    public void testDrawScore(){
        gui.drawScore(100);
        //Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 215, 0));
        //Mockito.verify(textGraphics, Mockito.times(1)).putString(0, 21, "Score: 100");
    }
    @Test
    public void testDrawHealth(){
        gui.drawHealth(100);
        //Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 215, 0));
        //Mockito.verify(textGraphics, Mockito.times(1)).putString(0, 20, "Health: 100");
    }
    @Test
    public void testDrawPowerups(){
        gui.drawPowerUp(new Position(10, 5));
        // Mockito.verify(textGraphics,Mockito.times(1)).setForegroundColor(new TextColor.RGB(255,215,0));
       // Mockito.verify(textGraphics,Mockito.times(1)).putString(10,5,"j");
    }
}
