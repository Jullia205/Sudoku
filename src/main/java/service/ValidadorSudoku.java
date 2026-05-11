package service;

public class ValidadorSudoku {

    public boolean validaCelula(int[][] tabuleiro, int linha, int coluna, int num){

        int quadranteColuna = (coluna/3)*3;
        int quadranteLinha = (linha/3)*3;

        for(int j=0; j<9;j++){
            if(j==coluna){
                continue;
            }
            else if(num==tabuleiro[linha][j]){
                return false;
            }
        }
        for(int i=0; i<9;i++){
            if(i==linha){
                continue;
            }
            else if(num==tabuleiro[i][coluna]){
                return false;
            }
        }
        for(int l=quadranteLinha; l<quadranteLinha+3;l++){
            for(int c=quadranteColuna; c<quadranteColuna+3;c++){
                if(l==linha && c==coluna){
                    continue;
                }
                else if(tabuleiro[l][c]==num){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validaVetor(int[] vetor, int num){
        for(int i=0; i<vetor.length; i++){
            if(vetor[i]==num){
                return false;
            }
        }
        return true;
    }
}
