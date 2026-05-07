package service;

public class ValidadorSudoku {

    public boolean validaCelula(int[][] tabuleiro, int linha, int coluna, int num){

        int quadranteColuna = (coluna/3)*3;
        int quadranteLinha = (linha/3)*3;

        for(int j=0; j<coluna;j++){
            if(num==tabuleiro[linha][j]){
                return false;
            }
        }
        for(int i=0; i<linha;i++){
            if(num==tabuleiro[i][coluna]){
                return false;
            }
        }
        for(int l=quadranteLinha; l<quadranteLinha+3;l++){
            for(int c=quadranteColuna; c<quadranteColuna+3;c++){
                if(tabuleiro[l][c]==num){
                    return false;
                }
            }
        }
        return true;
    }
}
