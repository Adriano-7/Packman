package ldts.pacman.state;


import ldts.pacman.Game;
import ldts.pacman.control.game.ArenaController;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.view.game.ArenaViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

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
    public void getViewer(){
        assertEquals(ArenaViewer.class,gameState.getViewer().getClass());
    }
    @Test
    public void getController(){
        assertEquals(ArenaController.class,gameState.getController().getClass());
    }

    @Test
    public void step() throws IOException {
        GUI gui=Mockito.mock(GUI.class);
        Game game = Mockito.mock(Game.class);
        Mockito.when(gui.getNextOption()).thenReturn(GUI.OPTION.QUIT);

        gameState.step(game,gui,1);

        Mockito.verify(gui, Mockito.times(1)).getNextOption();

        //assertEquals(MenuState.class, game.getState().getClass());
    }
}
