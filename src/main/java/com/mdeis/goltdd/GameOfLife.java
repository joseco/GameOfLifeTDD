package com.mdeis.goltdd;

public class GameOfLife {

    private boolean[][] cells;

    public GameOfLife(int rows, int cols) {
        if (rows < 0 || rows >= Integer.MAX_VALUE)
            throw new IllegalArgumentException("Los valores de las filas no pueden ser menor que cero o mayor o igual a " + Integer.MAX_VALUE);
        if (cols < 0 || cols >= Integer.MAX_VALUE)
            throw new IllegalArgumentException("Los valores de las columnas no pueden ser menor que cero o mayor o igual a " + Integer.MAX_VALUE);
        cells = new boolean[rows][cols];
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
        
    }
}
