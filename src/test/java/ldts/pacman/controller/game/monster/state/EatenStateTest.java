package ldts.pacman.controller.game.monster.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EatenStateTest {
    private EatenState eatenState;
    @BeforeEach
    public void setUp(){
        this.eatenState=new EatenState();
    }
    @Test
    public void getColor(){
        assertEquals("#FFFFFF", eatenState.getColor());
    }
    @Test
    public void getHit(){
        eatenState.getHit(null, null);
    }
}
