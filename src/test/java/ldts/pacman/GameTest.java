package ldts.pacman;

import ldts.pacman.model.menu.ScoreMenu;
import ldts.pacman.state.ScoreMenuState;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

public class GameTest {
    @Test
    public void nullStateTesting() {
        try {
            Game game = new Game();
            game.setState(null);
            game.run();
        }
        catch (IOException e) { fail(); }
    }
}
