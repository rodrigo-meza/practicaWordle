/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordle;

import java.util.ArrayList;

/**
 *
 * @author rodri
 */
public class TableroWordle {
    private int remainingTries;
    private TecladoWordle keyboard;
    private ArrayList<Intento> validTries;
    public TableroWordle(){
        keyboard= new TecladoWordle();
        remainingTries = 6;
        validTries = new ArrayList();
    } 
    public String showWordleUI(){
        StringBuffer sb = new StringBuffer();
        if(!validTries.isEmpty())
        {
            remainingTries--;
        }
        for (int i = 0 ; i<validTries.size() ; i++)
        {
            sb.append(validTries.get(i).toString()+"\n");
        }
        for (int i = 0 ; i<remainingTries ; i++)
            sb.append("[ ][ ][ ][ ][ ]\n");
        sb.append(keyboard.toString());
        sb.append("Escribe una palabra de 5 letras: ");
        return sb.toString();
    }

    public TecladoWordle getKeyboard() {
        return keyboard;
    }

    public int getRemainingTries() {
        return remainingTries;
    }

    public ArrayList<Intento> getValidTries() {
        return validTries;
    }
    
}
