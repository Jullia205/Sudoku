package model;

public class Tabuleiro {
    int[][] grid;

    public Tabuleiro(){
        this.grid = new int[9][9];
    }

    public void setValorCelula(Posicao p, int num) {
        grid[p.linha][p.coluna]=num;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
}
