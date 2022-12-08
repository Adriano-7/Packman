package ldts.pacman.state;


import ldts.pacman.controller.game.ArenaController;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.view.game.ArenaViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GameStateTest {
    public GameState gameState;
    public Arena arena;

    @BeforeEach
    public void setGameState(){
        arena=new Arena(5,5);
        gameState=new GameState(arena);
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
