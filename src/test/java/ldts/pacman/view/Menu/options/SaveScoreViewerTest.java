package ldts.pacman.view.Menu.options;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.menu.options.SaveScore;
import ldts.pacman.view.menu.options.OptionsViewer;
import ldts.pacman.view.menu.options.SaveScoreViewer;
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
    private OptionsViewer optionsViewer;
    private GUI gui;
    @BeforeEach
    public void setUp() {
        this.saveScore = Mockito.mock(SaveScore.class);
        this.optionsViewer = Mockito.mock(OptionsViewer.class);

        this.saveScoreViewer = new SaveScoreViewer(saveScore, optionsViewer);
        this.gui = Mockito.mock(GUI.class);

        Mockito.doNothing().when(optionsViewer).drawOptions(gui);
    }
    @Test
    public void getModel() {
        assertEquals(saveScore, saveScoreViewer.getModel());
    }
    @Test
    public void drawElements() throws IOException {
        saveScoreViewer.draw(gui);

        Mockito.verify(gui, times(1)).clear();
        Mockito.verify(gui, atLeastOnce()).drawText(any(), any(), any());
        Mockito.verify(gui, times(1)).refresh();
    }
    @Test
    public void draw() {
        try {
            saveScoreViewer.draw(gui);

            Mockito.verify(gui, times(1)).clear();
            Mockito.verify(optionsViewer, times(1)).drawOptions(gui);
            Mockito.verify(gui, times(1)).refresh();
        }
        catch (IOException e) {
            fail();
        }
    }
}
