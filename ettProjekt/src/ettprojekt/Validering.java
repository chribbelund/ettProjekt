/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ettprojekt;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author emmaj
 */
public class Validering {
    
//Metod för att kontrollera om inmatningsrutan är tom    
    public static boolean textFaltHarVarde(JTextField rutaAttKolla)
    {
        boolean resultat = true; 
        
        if(rutaAttKolla.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Inmatningsrutan är tom!");
            resultat = false;
        }
        
        return resultat;
    }
    
   
//Metod för att kontrollera att inmatningsrutan endast accepterar heltatsvärden 
    
    public static boolean isHeltal(JTextField rutaAttKolla)
    {
        boolean resultat= true;
        
        try {
           String inStrang = rutaAttKolla.getText();
           Integer.parseInt(inStrang);
        }
        catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null, "var god ange heltal");
        }
        
        return resultat;
} 

//Metod för att kontrollera att man skriver in rätt format av datum 
     static public boolean textContainsDate(JTextField text)
    {
        String  regEx ="^[1-2]+[0-9]+[0-9]+[0-9-]+[0-1]+[0-9-]+[0-3]+[0-9]";
        if(text.getText().matches(regEx))
        {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Ange datum åååå-mm-dd");
        }
        return false;
    }
    
}
