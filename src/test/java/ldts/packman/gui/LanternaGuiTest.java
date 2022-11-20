package ldts.packman.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import ldts.packman.model.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LanternaGuiTest {
    //Text java.ldts.packman LanternaGUI using mockito and junit
    private LanternaGUI gui;
    private Screen screen;
    private TextGraphics textGraphics;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        textGraphics = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(textGraphics);

        gui = new LanternaGUI(screen);
    }

    //Test drawHero
    @Test
    void drawPacman() {
        gui.drawPacman(null, new Position(2,3));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(2, 3, "@");
    }
}
