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

    public void gerar(){
        int num=0;
        for(int linha=0; linha<9; linha++){
            for(int coluna=0;coluna<9;coluna++){

                do{
                    num = randomNumber();
                }while(!validaCelula(tabuleiro,linha,coluna,num));
                tabuleiro[linha][coluna]=num;
            }
        }
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
