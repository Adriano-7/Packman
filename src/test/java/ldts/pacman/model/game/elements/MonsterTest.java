package ldts.pacman.model.game.elements;
import ldts.pacman.model.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MonsterTest {
    private Monster monster;
    @BeforeEach
    public void setCoin(){
        monster=new Monster(5,7);
    }
    @Test
    public void positionCoin(){
        assertEquals(new Position(5,7),monster.getPosition());
        System.out.println("\uD83D\uDC7B");
    }
}
