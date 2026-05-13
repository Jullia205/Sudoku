package service;

public class Solver extends GeradorSudoku {
    int backtracking;

    public boolean solver(int l, int c){
        if(l>8){
            return true;
        }
        for(int i=0; i<9; i++){
            if(validaCelulaVazia(tabuleiro,l,c) && validaCelula(tabuleiro,l,c,i)){
                tabuleiro[l][c]=i;
                if(c+1==9){
                    if(solver(l+1,0)){
                        return true;
                    }
                }
                else{
                    if (solver(l, c + 1)) {
                        return true;
                    }
                }
            }
            tabuleiro[l][c]=0;
            backtracking++;
        }
        return false;
    }
}
