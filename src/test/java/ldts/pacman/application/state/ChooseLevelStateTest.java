package ldts.pacman.application.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Collections;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import ldts.pacman.controller.menu.ChooseLevelController;
import ldts.pacman.gui.GUI;
import ldts.pacman.view.menu.ChooseLevelViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import ldts.pacman.Game;
import ldts.pacman.gui.GUI;
import ldts.pacman.controller.Controller;
import ldts.pacman.model.menu.ChooseLevel;
import ldts.pacman.view.Viewer;

/*
* Generate Unit tests using mockito and JUnit5 for the class ldts.pacman.application.state.ChooseLevelState
* */

public class ChooseLevelStateTest {
    ChooseLevel chooseLevel;
    ChooseLevelState chooseLevelState;

    @BeforeEach
    public void setUp(){
        chooseLevel = Mockito.mock(ChooseLevel.class);
        chooseLevelState = new ChooseLevelState(chooseLevel);
    }
    @Test
    public void getModel(){
        assertEquals(chooseLevel, chooseLevelState.getModel());
    }
    @Test
    public void getViewer(){
        assertEquals(ChooseLevelViewer.class, chooseLevelState.getViewer().getClass());
    }
    @Test
    public void getController(){
        assertEquals(ChooseLevelController.class, chooseLevelState.getController().getClass());
    }
}