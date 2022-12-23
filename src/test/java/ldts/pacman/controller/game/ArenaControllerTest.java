package ldts.pacman.controller.game;

import ldts.pacman.Game;
import ldts.pacman.application.state.menu.SaveScoreState;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Coin;
import ldts.pacman.model.game.elements.Pacman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;

public class ArenaControllerTest {
    private Arena arena;
    private ArenaController arenaController;
    @BeforeEach
    public void setUp() {
        this.arena = Mockito.mock(Arena.class);
        this.arenaController = new ArenaController(arena);
    }
    @Test
    public void quitGame() {
        Game game = Mockito.mock(Game.class);
        Pacman pacman = Mockito.mock(Pacman.class);
        Mockito.when(pacman.getHealth()).thenReturn(0);
        Mockito.when(arena.getPacman()).thenReturn(pacman);

        try {
            arenaController.step(game, List.of(GUI.OPTION.QUIT), 0);
        }
        catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            fail();
        }
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(SaveScoreState.class));
        Mockito.verify(pacman, times(1)).getScore();
    }

    @Test
    public void stepZeroHealth() {
        Game game = Mockito.mock(Game.class);
        Pacman pacman = Mockito.mock(Pacman.class);
        Mockito.when(pacman.getHealth()).thenReturn(0);
        Mockito.when(arena.getPacman()).thenReturn(pacman);
        try {
            arenaController.step(game, List.of(), 0);
        }
        catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            fail();
        }
        Mockito.verify(pacman, times(1)).getScore();
        Mockito.verify(game, times(1)).setState(Mockito.any(SaveScoreState.class));
    }
    @Test
    public void coinsEmpty() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Mockito.when(arena.getCoins()).thenReturn(List.of());

        Game game = Mockito.mock(Game.class);
        Pacman pacman = Mockito.mock(Pacman.class);
        Mockito.when(pacman.getHealth()).thenReturn(1);
        Mockito.when(arena.getPacman()).thenReturn(pacman);

        arenaController.step(game, List.of(), 0);

        Mockito.verifyNoInteractions(game);

        Mockito.verify(pacman, times(1)).getHealth();
        Mockito.verifyNoMoreInteractions(pacman);

        Mockito.verify(arena, times(1)).getCoins();
        Mockito.verify(arena, times(1)).resetLevel();
    }
    @Test
    public void stepNormal() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Game game = Mockito.mock(Game.class);
        Pacman pacman = Mockito.mock(Pacman.class);
        Mockito.when(pacman.getHealth()).thenReturn(2);
        Mockito.when(arena.getPacman()).thenReturn(pacman);
        Mockito.when(arena.getCoins()).thenReturn(List.of(Mockito.mock(Coin.class)));

        arenaController.step(game, List.of(), 0);

        Mockito.verifyNoInteractions(game);
        Mockito.verify(arena, times(0)).resetLevel();

    }
}
