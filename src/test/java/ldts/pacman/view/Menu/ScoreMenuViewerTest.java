package ldts.pacman.view.Menu;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.menu.ScoreMenu;
import ldts.pacman.view.menu.ScoreMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;

public class ScoreMenuViewerTest {
    private ScoreMenu scoreMenu;
    private ScoreMenuViewer scoreMenuViewer;
    private GUI gui;
    @BeforeEach
    public void setUp() {
        gui = Mockito.mock(GUI.class);
        scoreMenu = Mockito.mock(ScoreMenu.class);
        scoreMenuViewer = new ScoreMenuViewer(scoreMenu);
    }
    @Test
    public void getModel() {
        assertEquals(scoreMenu, scoreMenuViewer.getModel());
    }
    @Test
    public void drawElements() {
        scoreMenuViewer.drawElements(gui);

        Mockito.verify(gui, atLeastOnce())
                .drawText(any(Position.class), any(String.class), any(String.class));
    }
    @Test
    public void draw() {
        ScoreMenuViewer spy = Mockito.spy(scoreMenuViewer);
        Mockito.doNothing().when(spy).drawElements(gui);
        try {
            spy.draw(gui);

            Mockito.verify(gui, times(1)).clear();
            Mockito.verify(spy, times(1)).drawElements(gui);
            Mockito.verify(gui, times(1)).refresh();
        }
        catch (IOException e) {
            fail();
        }
    }
}
