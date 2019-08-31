package com.mdeis.goltdd;

public class GameOfLife {

    private boolean[][] cells;
    private int rows;
    private int cols;

    public GameOfLife(int rows, int cols) {
        if (rows < 0 || rows >= Integer.MAX_VALUE)
            throw new IllegalArgumentException("Los valores de las filas no pueden ser menor que cero o mayor o igual a " + Integer.MAX_VALUE);
        if (cols < 0 || cols >= Integer.MAX_VALUE)
            throw new IllegalArgumentException("Los valores de las columnas no pueden ser menor que cero o mayor o igual a " + Integer.MAX_VALUE);
        cells = new boolean[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }

    public void setCellStatus(int i, int j, boolean status) {
        if (i < 0 || i >= cells.length || j < 0 || j >= cells[i].length)
            throw new IllegalArgumentException("Las posiciones son inválidas");
        cells[i][j] = status;
    }

    public boolean isAlive(int i, int j) {
        return cells[i][j];
    }

    public void play(){
        boolean[][] newCellStatus = new boolean[rows][cols];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {

                int numberOfNeighbors = countNeighbors(i, j);
                newCellStatus[i][j] =
                        isAlive(i,j) && (numberOfNeighbors == 2 || numberOfNeighbors == 3) ||
                        !isAlive(i,j) && numberOfNeighbors == 3;
            }
        }
        cells = newCellStatus;
    }

    private int countNeighbors(int i, int j){
        int counter = 0;

        int upPosition =  i - 1;
        int downPosition =  i + 1;
        boolean canGoUp = upPosition >= 0;
        boolean canGoDown = downPosition < rows;

        int leftPosition =  j - 1;
        int rightPosition =  j + 1;
        boolean canGoToLeft = leftPosition >= 0;
        boolean canGoToRight = rightPosition < cols;

        // CASO 1: i - 1, j - 1     CASO 2: i - 1 , j       CASO 3: i - 1, j + 1
        // CASO 4:  i  , j - 1          CELL(i, j)          CASO 5:   i  , j + 1
        // CASO 6: i + 1, j - 1     CASO 7: i + 1 , j       CASO 8: i + 1, j + 1

        // Casos de la fila de Arriba
        if(canGoUp) {
            // CASO 1
            if (canGoToLeft && isAlive(upPosition, leftPosition))
            counter++;

            // CASO 2
            if (isAlive(upPosition, j))
                counter++;

            // CASO 3
            if (canGoToRight && isAlive(upPosition, rightPosition))
                counter++;
        }
        // CASO 4
        if(canGoToLeft && isAlive(i, leftPosition))
            counter++;

        // CASO 5
        if(canGoToRight && isAlive(i, rightPosition))
            counter++;

        // Casos para la fila de Arriba
        if(canGoDown){
            // CASO 6
            if(canGoToLeft && isAlive(downPosition, leftPosition))
                counter++;

            // CASO 7
            if(isAlive(downPosition, j))
                counter++;

            // CASO 8
            if(canGoToRight && isAlive(downPosition, rightPosition))
                counter++;
        }

        return counter;
    }
}
