
import com.mdeis.goltdd.GameOfLife;
import org.junit.Assert;
import org.junit.Test;

public class GameOfLifeTest {

    @Test(expected = IllegalArgumentException.class)
    public void simpleGameSetup(){
        GameOfLife game = new GameOfLife(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

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

    @Test
    public void setupCellAsAliveWithNegativePosition(){

        //Se realiza la configuracion inicial del tablero
        //y se asgina un estado a una celula en una posicion invalida
        GameOfLife game = new GameOfLife(1,1);
        game.setCellStatus(-1,-1, true);

        boolean actual = game.isAlive(-1,-1);
        boolean expected = true;

        Assert.assertEquals(expected, actual);

    }

    @Test(expected = IllegalArgumentException.class)
    public void setupCellAsAliveWithInvalidPosition(){

        //Se realiza la configuracion inicial del tablero
        //y se asgina un estado a una celula en una posicion invalida
        GameOfLife game = new GameOfLife(1,1);
        game.setCellStatus(1,1, true);

        boolean actual = game.isAlive(1,1);
        boolean expected = true;

        Assert.assertEquals(expected, actual);

    }

}
