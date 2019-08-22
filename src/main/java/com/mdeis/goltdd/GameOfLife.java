package com.mdeis.goltdd;

public class GameOfLife {

    private boolean[][] cells;

    public GameOfLife(int rows, int cols){
        cells = new boolean[rows][cols];
    }

    public void setCellStatus(int i, int j, boolean status){
        if(i < 0 || i >= cells.length || j < 0 || j >= cells[i].length)
            throw new IllegalArgumentException("Las posiciones son inválidas");
        cells[i][j] = status;
    }

    public boolean isAlive(int i, int j){
        return cells[i][j];
    }
}
