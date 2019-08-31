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
        //Configuracion inicial
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

        // Resultado esperado
        //   0 1 2 3 4
        //0  O O O O O
        //1  O O O O O
        //2  O O 0 O O
        //3  O O O O O
        //4  O O O O O

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void playGameWithSetup1() {
        GameOfLife game = new GameOfLife(6, 6);
        //Configuracion inicial
        //   0 1 2 3 4 5
        //0  O O O O O 0
        //1  O O O O O 0
        //2  O O 1 1 O 0
        //3  O O 1 1 O 0
        //4  O O O O O 0
        //5  O O O O O 0

        game.setCellStatus(2, 2, true);
        game.setCellStatus(2, 3, true);
        game.setCellStatus(3, 2, true);
        game.setCellStatus(3, 3, true);

        //   0 1 2 3 4 5
        //0  O O O O O 0
        //1  O O O O O 0
        //2  O O 1 1 O 0
        //3  O O 1 1 O 0
        //4  O O O O O 0
        //5  O O O O O 0

        for (int i = 0; i < 3; i++) {

            game.play();

            boolean actual = game.isAlive(2, 2) &&
                    game.isAlive(2, 3) &&
                    game.isAlive(3, 2) &&
                    game.isAlive(2, 3);
            boolean expected = true;

            Assert.assertEquals(expected, actual);
        }
    }

        @Test
        public void playGameWithSetup2(){
            GameOfLife game = new GameOfLife(5,5);
            //Configuracion inicial
            //   0 1 2 3 4
            //0  O O O O O
            //1  O O 0 O O
            //2  O 1 1 1 O
            //3  O O 0 O O
            //4  O O O O O

            game.setCellStatus(2,1,true);
            game.setCellStatus(2,2,true);
            game.setCellStatus(2,3,true);

            // Step 1
            //   0 1 2 3 4
            //0  O O O O O
            //1  O O 1 O O
            //2  O 0 1 0 O
            //3  O O 1 O O
            //4  O O O O O

            game.play();

            boolean[][] expectedAfterOneIteration = {
                    {false, false, false, false, false},
                    {false, false, true,  false, false},
                    {false, false, true,  false, false},
                    {false, false, true,  false, false},
                    {false, false, false, false, false},
            };
            int expectedNumberOfRows = 5;
            boolean[][] actual = game.getCells();
            int actualNumberOfRows = actual.length;
            Assert.assertEquals(expectedNumberOfRows, actualNumberOfRows);
            if(actualNumberOfRows == expectedNumberOfRows) {
                for (int i = 0; i < actualNumberOfRows; i++) {
                    Assert.assertArrayEquals(expectedAfterOneIteration[i], actual[i]);
                }
            }

            // Step 2
            //   0 1 2 3 4
            //0  O O O O O
            //1  O O 0 O O
            //2  O 1 1 1 O
            //3  O O 0 O O
            //4  O O O O O
            boolean[][] expectedAfterTwoIterations = {
                    {false, false, false, false, false},
                    {false, false, false, false, false},
                    {false, true,  true,  true,  false},
                    {false, false, false, false, false},
                    {false, false, false, false, false},
            };
            game.play();
            expectedNumberOfRows = 5;
            actual = game.getCells();
            actualNumberOfRows = actual.length;
            Assert.assertEquals(expectedNumberOfRows, actualNumberOfRows);
            if(actualNumberOfRows == expectedNumberOfRows) {
                for (int i = 0; i < actualNumberOfRows; i++) {
                    Assert.assertArrayEquals(expectedAfterTwoIterations[i], actual[i]);
                }
            }
        }

}
