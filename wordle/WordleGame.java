/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordle;

import java.util.Scanner;

/**
 *
 * @author rodri
 */
public class WordleGame {
    private TableroWordle board;
    private WordleCompare comparer;
    public WordleGame(){
        board = new TableroWordle();
        comparer = new WordleCompare();
    }
    public void playWordle(){
        Scanner strSc = new Scanner(System.in);
        String wordToTry;
        char [] correct = new char[5];
        System.out.println("Bienvenido a Wordle. Intenta adivinar la palabra en 6 intentos...\nEjemplo de intento: [a][r][b][o][l] [=][*][*][X][*]\n= significa que la letra esta donde debe\n * significa que esta en el lugar equivocado\n X significa que no esta en la palabra\n");
        do{    
            System.out.println(board.showWordleUI());
            do{
                wordToTry = strSc.nextLine();
                if(wordToTry.length()!=5||!comparer.getWordBank().contains(wordToTry)){
                    System.out.println("Palabra invalida.\nIntroduce otra");
                }
            }while(wordToTry.length()!=5||!comparer.getWordBank().contains(wordToTry));
            comparer.compareTriedToReal(wordToTry,board.getKeyboard());
            board.getValidTries().add(new Intento(wordToTry,comparer.getTriedLetterStatus()));
        }while(board.getRemainingTries()>1&&!comparer.getWordToGuess().equals(wordToTry)); 
        if(!comparer.getWordToGuess().equals(wordToTry)&&board.getRemainingTries()<=1)
            System.out.println("Perdiste...\nLa palabra era "+comparer.getWordToGuess());
        else if(comparer.getWordToGuess().equals(wordToTry))
            System.out.println("Ganaste!!\n");
    }
}
