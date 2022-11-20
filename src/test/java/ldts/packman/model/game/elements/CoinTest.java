package ldts.packman.model.game.elements;
import ldts.packman.model.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinTest {
    private Coin coin;
    @BeforeEach
    public void setCoin(){
        coin=new Coin(5,7);
    }
    @Test
    public void positionCoin(){
        assertEquals(new Position(5,7),coin.getPosition());
    }

}
