package service;

public class GeradorSudoku extends ValidadorSudoku {
    int[][] tabuleiro;

    public GeradorSudoku() {
        this.tabuleiro = new int[9][9];
    }

    public int randomNumber(){
        int range=9-1+1;
        return (int)(Math.random()*range)+1;
    }

    public boolean gerar(int l, int c){
        if(l>8){
            return true;
        }
        for(int num=1; num<=9; num++){
            if(validaCelula(tabuleiro,l,c,num)){
                tabuleiro[l][c]=num;
                if(c+1==9){
                    if(gerar(l+1,0)){
                        return true;
                    }
                }
                else{
                    if (gerar(l, c + 1)) {
                        return true;
                    }
                }
            }
            tabuleiro[l][c]=0;
        }
        return false;
    }

    public void mostraTabuleiro(){
        int contC=0;
        int contL=0;
        for(int linha=0; linha<9;linha++){
            for(int coluna=0; coluna<9;coluna++){
                System.out.print(tabuleiro[linha][coluna]+" ");
                contC++;
                if(contC%3==0){
                    System.out.print("| ");
                }
            }
            System.out.println(" ");
            contL++;
            if(contL%3==0){
                System.out.println("-----------------------");
            }
        }
    }
}
