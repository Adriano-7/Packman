package ldts.pacman.controller.game;


import ldts.pacman.controller.game.monster.state.ScaredState;
import ldts.pacman.controller.game.movement.strategy.player.PacmanPlayerStrategy;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Pacman;
import ldts.pacman.model.game.elements.monsters.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

public class PacmanControllerTest {
    private PacmanController pacmanController;
    private Arena arena;
    private PacmanPlayerStrategy pacmanStrategy;
    @BeforeEach
    public void setUp() {
        this.arena = Mockito.mock(Arena.class);
        this.pacmanStrategy = Mockito.mock(PacmanPlayerStrategy.class);
        this.pacmanController = new PacmanController(arena, pacmanStrategy);
    }
    @Test
    public void stepNothing() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Mockito.when(pacmanStrategy.move(any(), any(), any(), anyLong())).thenReturn(false);

        pacmanController.step(null, null, 0);

        Mockito.verify(pacmanStrategy, times(1)).move(any(), any(), any(), anyLong());
        Mockito.verify(arena, times(1)).getPacman();

        Mockito.verifyNoMoreInteractions(pacmanStrategy, arena);
    }
    private void setUpAllTrue(Monster monster) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Mockito.when(pacmanStrategy.move(any(), any(), any(), anyLong())).thenReturn(true);

        Pacman notNullPacman = Mockito.mock(Pacman.class);
        Mockito.when(arena.getPacman()).thenReturn(notNullPacman);

        Mockito.when(arena.getCollidingMonster(Mockito.any())).thenReturn(monster);
        Mockito.when(arena.getMonsters()).thenReturn(List.of(monster));

        Mockito.when(arena.collectPowerUp()).thenReturn(true);
    }
    @Test
    public void stepAllTrueBranch() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Monster monster = Mockito.mock(Monster.class);
        setUpAllTrue(monster);

        pacmanController.step(null, null, 0);

        Mockito.verify(monster, times(1)).getHit(arena);
        Mockito.verify(arena, times(1)).collectCoin();
        Mockito.verify(arena, times(1)).collectPowerUp();
        Mockito.verify(monster, times(1))
                .setState(Mockito.any(ScaredState.class));

    }
    @Test
    public void stepFirstFalseBranch() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Monster monster = Mockito.mock(Monster.class);
        setUpAllTrue(monster);
        Mockito.when(arena.getCollidingMonster(Mockito.any())).thenReturn(null);

        pacmanController.step(null, null, 0);

        Mockito.verify(monster, never()).getHit(arena);
        Mockito.verify(arena, times(1)).collectCoin();
        Mockito.verify(arena, times(1)).collectPowerUp();
        Mockito.verify(monster, times(1))
                .setState(Mockito.any(ScaredState.class));
    }
    @Test
    public void stepSecondFalseBranch() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Monster monster = Mockito.mock(Monster.class);
        setUpAllTrue(monster);

        Mockito.when(arena.collectPowerUp()).thenReturn(false);

        pacmanController.step(null, null, 0);

        Mockito.verify(monster, times(1)).getHit(arena);
        Mockito.verify(arena, times(1)).collectCoin();
        Mockito.verify(arena, times(1)).collectPowerUp();
        Mockito.verify(monster, never()).setState(Mockito.any());
    }
}
