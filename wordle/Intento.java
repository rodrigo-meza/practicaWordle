/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordle;

/**
 *
 * @author rodri
 */
public class Intento {
    private String triedWord;
    private char[] tryStatus;
    public Intento(String triedWord, char[]tryStatus){
        this.triedWord = triedWord;
        this.tryStatus = tryStatus;
    }
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        for(int i =0 ; i<5 ; i++)
        {    
            sb.append("["+triedWord.charAt(i)+"]");
            
        }   
        for(int i =0 ; i<5 ; i++)
        {    
            sb.append("["+tryStatus[i]+"]");
            
        }
        return sb.toString();
    }
}
