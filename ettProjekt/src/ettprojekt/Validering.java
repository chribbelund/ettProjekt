/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ettprojekt;

import static ettprojekt.EttProjekt.idb;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import oru.inf.InfException;

/**
 *
 * @author emmaj
 */
public class Validering {

//Metod för att kontrollera om inmatningsrutan är tom    
    public static boolean textFaltHarVarde(JTextField rutaAttKolla) {
        boolean resultat = true;

        if (rutaAttKolla.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Inmatningsrutan är tom!");
            rutaAttKolla.requestFocus();
            resultat = false;
        }

        return resultat;
    }

//Metod för att kontrollera att inmatningsrutan endast accepterar heltatsvärden 
    public static boolean isHeltal(JTextField rutaAttKolla) {
        boolean resultat = true;

        try {
            String inStrang = rutaAttKolla.getText();
            Integer.parseInt(inStrang);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "var god ange heltal");
        }

        return resultat;
    }

//Metod för att kontrollera att man skriver in rätt format av datum 
    static public boolean textContainsDate(JTextField text) {
        String regEx = "^[1-2]+[0-9]+[0-9]+[0-9-]+[0-1]+[0-9-]+[0-3]+[0-9]";
        if (text.getText().matches(regEx)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Ange datum åååå-mm-dd");
        }
        return false;
    }

    public boolean isUsernameCorrect(JTextField txtUsername) {
        boolean correctUsername = false;
        try {
            String svar = null;
            //Skriv om denna fråga så att den fungerar med databasen
            String fraga = "SELECT EFTERNAMN FROM LARARE WHERE EFTERNAMN = '" + txtUsername.getText() + "';";
            svar = idb.fetchSingle(fraga);
            if (svar == null) {
                JOptionPane.showMessageDialog(null, "Fel användarnamn!");
                txtUsername.requestFocus();
            } else {
                correctUsername = true;
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
            System.out.println("Internt felmeddelande" + e.getMessage());
        }

        return correctUsername;
    }

    public boolean isPasswordCorrect(JTextField txtUsername, String txtPassword) {
        boolean passwordIsCorrect = true;

        try {
            String username = txtUsername.getText();
            String password = txtPassword;
            //Skriv om denna metod så att den fungerar med databasen
            String correctPassword = "SELECT LARARE.LOSENORD FROM LARARE WHERE EFTERNAMN = '" + username + "';";
            correctPassword = idb.fetchSingle(correctPassword);

            if (!(password.equals(correctPassword))) {
                passwordIsCorrect = false;
                JOptionPane.showMessageDialog(null, "Fel lösen. Försök igen");
            }

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
            System.out.println("Internt felmeddelande" + e.getMessage());
        }
        return passwordIsCorrect;
    }

    public boolean isAdminCorrect(JTextField txtUsername) {
        boolean isAdmin = false;
        try {
            String username = txtUsername.getText();
            String fraga = "SELECT LARARE.ADMINISTRATOR FROM LARARE WHERE EFTERNAMN = '" + username + "';";
            String admin = idb.fetchSingle(fraga);
            if (admin.equals("T")) {
                isAdmin = true;
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
            System.out.println("Internt felmeddelande" + e.getMessage());
        }
        return isAdmin;
    }

}
