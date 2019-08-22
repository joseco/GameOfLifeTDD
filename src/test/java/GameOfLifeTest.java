
import com.mdeis.goltdd.GameOfLife;
import org.junit.Assert;
import org.junit.Test;

public class GameOfLifeTest {

    @Test
    public void setupCellAsAlive(){
        //Se realiza la configuracion inicial del tablero
        //y se asgina un estado a una celula
        GameOfLife game = new GameOfLife(1,1);
        game.setCellStatus(0,0, true);

        boolean actual = game.isAlive(0,0);
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setupCellAsAliveWithInvalidPosition(){

        //Se realiza la configuracion inicial del tablero
        //y se asgina un estado a una celula
        GameOfLife game = new GameOfLife(1,1);
        game.setCellStatus(-1,-1, true);

        boolean actual = game.isAlive(0,0);
        boolean expected = true;

        Assert.assertEquals(expected, actual);

    }

}
