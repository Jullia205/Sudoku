package service;

public class Solver {
    public boolean solver(int l, int c){
        if(l>8){
            return true;
        }
        for(int i=0; i<9; i++){
            if(validaCelula(tabuleiro,l,c,i)){
                tabuleiro[l][c]=i;
                if(c+1==9){
                    if(gerarTabuleiro(l+1,0)){
                        return true;
                    }
                }
                else{
                    if (gerarTabuleiro(l, c + 1)) {
                        return true;
                    }
                }
            }
            tabuleiro[l][c]=0;
        }
        return false;
    }
}
