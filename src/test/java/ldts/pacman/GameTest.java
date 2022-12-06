package ldts.pacman;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.fail;

public class GameTest {
    @Test
    public void nullStateTesting() {
        try {
            Game game = new Game();
            game.setState(null);
            game.run();
        }
        catch (IOException | URISyntaxException | FontFormatException e ) {
            fail();
        }
    }
}
