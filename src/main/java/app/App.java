package app;
import service.GeradorSudoku;

public class App {
    public static void main(String[] args){
        GeradorSudoku tabuleiro = new GeradorSudoku();
        tabuleiro.gerarPuzzle();
    }

}
