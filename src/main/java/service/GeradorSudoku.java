package service;

import model.Tabuleiro;

public class GeradorSudoku extends ValidadorSudoku {
    int[][] tabuleiro;
    int[] randomNums;

    public GeradorSudoku() {
        this.randomNums = randomNumber();
    }

    public int[] randomNumber(){
        int range=9-1+1;
        int cont=0;
        int[] randomNums = new int[9];
        do{
            int num=(int)(Math.random()*range)+1;
            if(!validaVetor(randomNums, num)){
                continue;
            }
            else{
                randomNums[cont]=num;
                cont++;
            }
        }while(cont<9);
        return randomNums;
    }

    public boolean gerarTabuleiro(int l,int c){
        if(l>8){
            return true;
        }
        for(int i=0; i<randomNums.length; i++){
            if(validaCelula(tabuleiro, l, c, randomNums[i])){
                tabuleiro[l][c]=randomNums[i];
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

    public void apagaCelula(){
        gerarTabuleiro(0,0);
        int cont=0;
        int range=9-1+1;
        do{
            int l=(int)(Math.random()*range);
            int c=(int)(Math.random()*range);
            if(tabuleiro[l][c]==0){
                continue;
            } else{
                tabuleiro[l][c]=0;
                cont++;
            }
        }while(cont<35);
    }

    public Tabuleiro gerarPuzzle(){
        Tabuleiro grid = new Tabuleiro();
        apagaCelula();
        grid.setGrid(tabuleiro);
        return grid;
    }

    public void dificuldade(){
        int recursao = 0;
        int backtrack = 0;

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
