package service;

public class Solver extends ValidadorSudoku {
    int backtracking;
    int[][] tabuleiro;

    public Solver (int[][] tabuleiro){
        this.tabuleiro = tabuleiro;
    }


    public boolean solver(int l, int c){
        if(l>8){
            return true;
        }
        if(!validaCelulaVazia(tabuleiro,l,c)){
            if (c + 1 == 9) {
                if (solver(l + 1, 0)) {
                    return true;
                }
            } else {
                if (solver(l, c + 1)) {
                    return true;
                }
            }
        }
        else{
            for(int i=1; i<=9; i++) {
                if (validaCelula(tabuleiro, l, c, i)) {
                    tabuleiro[l][c] = i;
                    if (c + 1 == 9) {
                        if (solver(l + 1, 0)) {
                            return true;
                        }
                    } else {
                        if (solver(l, c + 1)) {
                            return true;
                        }
                    }
                }
                tabuleiro[l][c] = 0;
            }
        }
        backtracking++;
        return false;
    }
}
