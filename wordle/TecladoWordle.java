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
public class TecladoWordle {
    private ArrayList<Character> keyboard1= new ArrayList();
    private ArrayList<Character> keyboard2= new ArrayList();
    private ArrayList<Character> keyboard3= new ArrayList();
    
    public TecladoWordle()
    {
        for (int i = 0 ; i<10 ; i++){
            keyboard1.add(Teclado.values()[i].toString().charAt(0));
        }    
        for (int i = 0 ; i<9 ; i++){
            keyboard2.add(Teclado.values()[i+10].toString().charAt(0));
        }    
        for (int i = 0 ; i<7 ; i++){
            keyboard3.add(Teclado.values()[i+19].toString().charAt(0));
        }
    }
    public void removeLetter (char toRemove){
        Character rmv = toRemove;
        keyboard1.remove(rmv);
        keyboard2.remove(rmv);
        keyboard3.remove(rmv);
        
    }
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(int i =0 ; i < keyboard1.size() ; i++)
        {
           sb.append("["+keyboard1.get(i)+"]");
        }
        sb.append("\n  ");
        for(int i =0 ; i < keyboard2.size() ; i++)
        {
           sb.append("["+keyboard2.get(i)+"]");
        }
        sb.append("\n     ");
        for(int i =0 ; i < keyboard3.size() ; i++)
        {
           sb.append("["+keyboard3.get(i)+"]");
        }
        sb.append("\n");
        return sb.toString();
    }
}
