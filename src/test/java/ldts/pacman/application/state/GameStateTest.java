package ldts.pacman.application.state;


import ldts.pacman.controller.game.ArenaController;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.view.game.ArenaViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class GameStateTest {
    private GameState gameState;
    private Arena arena;

    @BeforeEach
    public void setGameState(){
        this.arena = Mockito.mock(Arena.class);

        this.gameState = new GameState(arena);
    }
    @Test
    public void testGetModel(){
        assertEquals(arena,gameState.getModel());
    }
    @Test
    public void getViewer(){
        assertEquals(ArenaViewer.class,gameState.getViewer().getClass());
    }
    @Test
    public void getController(){
        assertEquals(ArenaController.class,gameState.getController().getClass());
    }
}
