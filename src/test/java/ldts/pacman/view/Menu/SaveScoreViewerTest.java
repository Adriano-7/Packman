package ldts.pacman.view.Menu;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.menu.SaveScore;
import ldts.pacman.sound.observer.SoundSelection;
import ldts.pacman.sound.subject.SoundSubject;
import ldts.pacman.view.menu.SaveScoreViewer;
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
    private SaveScore saveScore;
    private SaveScoreViewer saveScoreViewer;
    private GUI gui;
    @BeforeEach
    public void setUp() {
        SoundSelection soundSelection = Mockito.mock(SoundSelection.class);
        saveScore = new SaveScore(soundSelection, 100);
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

        Mockito.verify(gui, atLeastOnce()).drawText(any(Position.class), any(String.class), any(String.class));
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
