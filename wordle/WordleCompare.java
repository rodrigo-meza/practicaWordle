/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordle;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author rodri
 */
public class WordleCompare {

    private String wordToGuess;
    
    private char[] triedLetterStatus;
    private ArrayList<String> wordBank;

    public WordleCompare() {
        Random rnd = new Random();
        wordBank = new ArrayList();
        for(int i = 0 ; i<PalabrasDeCincoLetras.values().length ; i++){
            wordBank.add(PalabrasDeCincoLetras.values()[i].toString());
        }
        wordToGuess = wordBank.get(rnd.nextInt(wordBank.size()));
        triedLetterStatus = new char[5];
    }

    public void compareTriedToReal(String triedWord,TecladoWordle erasing) {
        int triedLetterIndex;
        int realLetterIndex = 0;
        triedLetterStatus = new char[5];
        for (triedLetterIndex = 0; triedLetterIndex < 5 ; triedLetterIndex++) {
            do {
                if(triedLetterStatus[realLetterIndex]!='=')
                {
                    if (wordToGuess.charAt(realLetterIndex) == triedWord.charAt(triedLetterIndex) && realLetterIndex == triedLetterIndex) {
                        triedLetterStatus[triedLetterIndex] = '=';
                        
                    } else if (wordToGuess.charAt(realLetterIndex) == triedWord.charAt(triedLetterIndex)&& realLetterIndex != triedLetterIndex) {
                        triedLetterStatus[triedLetterIndex] = '*';
                    } else {
                        triedLetterStatus[triedLetterIndex] = 'X';
                    }
                }
                realLetterIndex++;
            } while (realLetterIndex < 5 && triedLetterStatus[triedLetterIndex] != '=' && triedLetterStatus[triedLetterIndex] != '*');
            realLetterIndex=0;
        }
        for (int i = 0 ; i<5 ; i++)
            if(triedLetterStatus[i]=='X') erasing.removeLetter(triedWord.charAt(i));
        
    }

    public char[] getTriedLetterStatus() {
        return triedLetterStatus;
    }

    public ArrayList<String> getWordBank() {
        return wordBank;
    }
    public String getWordToGuess() {
        return wordToGuess;
    }
}   
