package com.mdeis.goltdd.test;

import com.mdeis.goltdd.GameOfLife;
import org.junit.Assert;
import org.junit.Test;

public class GameOfLifeTest {

    /**
     * Verifica si los parámetros de la creacion del juego son válidos
     * para valores que excedan los valores permitidos para un arreglo
     */
    @Test(expected = IllegalArgumentException.class)
    public void simpleGameSetup(){
        GameOfLife game = new GameOfLife(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Verifica si los parámetros de la creacion del juego son válidos
     * para valores negativos
     */
    @Test(expected = IllegalArgumentException.class)
    public void simpleGameSetupWithNegativeParameters(){
        GameOfLife game = new GameOfLife(-1, -1);
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

    @Test(expected = IllegalArgumentException.class)
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

    @Test
    public void playGameWithOnlyCell(){
        GameOfLife game = new GameOfLife(5,5);
        //   0 1 2 3 4
        //0  O O O O O
        //1  O O O O O
        //2  O O 1 O O
        //3  O O O O O
        //4  O O O O O

        game.setCellStatus(2,2,true);
        game.play();
        boolean actual = game.isAlive(2,2);
        boolean expected = false;

        Assert.assertEquals(expected, actual);
    }

}
