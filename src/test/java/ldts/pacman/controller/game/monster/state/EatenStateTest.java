package ldts.pacman.controller.game.monster.state;
import ldts.pacman.controller.game.monster.state.EatenState;
import ldts.pacman.model.game.elements.Monster;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EatenStateTest {
    private EatenState eatenState;
    private Monster monster;
    @BeforeEach
    public void setUp(){
        this.eatenState=new EatenState();
    }
    @Test
    public void getColor(){
        assertEquals("#2121ff", eatenState.getColor());
    }
    @Test
    public void getHit(){
        eatenState.getHit(null, null);
    }
}
