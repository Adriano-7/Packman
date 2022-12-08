package ldts.pacman.view.Menu;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.menu.SaveScore;
import ldts.pacman.model.menu.ScoreMenu;
import ldts.pacman.view.menu.SaveScoreViewer;
import ldts.pacman.view.menu.ScoreMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;

public class SaveScoreViewerTest {
    SaveScore saveScore;
    SaveScoreViewer saveScoreViewer;
    GUI gui;
    @BeforeEach
    public void setUp() {
        saveScore = new SaveScore(100);
        saveScoreViewer = new SaveScoreViewer(saveScore);
        gui = Mockito.mock(GUI.class);
    }
    @Test
    public void getModel() {
        assertEquals(saveScore, saveScoreViewer.getModel());
    }
    @Test
    public void drawElements() {
        saveScoreViewer.drawElements(gui);

        Mockito.verify(gui, atLeastOnce())
                .drawText(any(Position.class), any(String.class), any(String.class));
    }
    @Test
    public void draw() {
        SaveScoreViewer spy = Mockito.spy(saveScoreViewer);
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
