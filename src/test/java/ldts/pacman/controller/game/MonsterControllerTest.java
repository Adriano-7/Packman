package ldts.pacman.controller.game;

import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Pacman;
import ldts.pacman.model.game.elements.monsters.bot.RedMonster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MonsterControllerTest {
    private MonsterController monsterController;
    @BeforeEach
    public void setUp() {
        Arena arena = Mockito.mock(Arena.class);
        Mockito.when(arena.getMonsters()).thenReturn(List.of(new RedMonster(5, 5)));
        Mockito.when(arena.isWall(Mockito.any())).thenReturn(false);
        Mockito.when(arena.getPacman()).thenReturn(new Pacman(0, 0));
        this.monsterController = new MonsterController(arena);
    }
    @Test
    public void stepAllMonstersMove() {
        try {
            monsterController.step(null, null, 700);
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            fail();
        }
        assertNotEquals(new Position(5, 5), monsterController.getModel().getMonsters().get(0).getPosition());
    }
    @Test
    public void stepAllMonstersDontMove() {
        try {
            monsterController.step(null, null, 400);
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            fail();
        }
        assertEquals(new Position(5, 5), monsterController.getModel().getMonsters().get(0).getPosition());
    }
}