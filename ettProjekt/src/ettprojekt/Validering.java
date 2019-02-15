/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ettprojekt;

import static ettprojekt.EttProjekt.userDir;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import oru.inf.InfException;
import oru.inf.InfDB;
import java.io.*;
import java.util.regex.Matcher;
import javax.swing.JPasswordField;

/**
 *
 * @author emmaj
 */
public class Validering {

    private InfDB idb;

    public Validering() {
        userDir = System.getProperty("user.dir"); //Hämtar vart programmet körs ifrån
        userDir += "/lib/DATABASE.FDB"; //Pekar på vart databasen ligger lagrad
        try {
            idb = new InfDB(EttProjekt.userDir);
        } catch (InfException ettUndantag) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
        }
    }

    public static boolean isString(JTextField txtNamn) {
        boolean isString = false;

        if (txtNamn.getText().matches("[a-zA-Z]+")) {
            isString = true;
        } else {
            JOptionPane.showMessageDialog(null, "Ange ett korrekt namn");
            txtNamn.requestFocus();
        }
        return isString;
    }
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

//Metod för att kontrollera om inmatningsrutan för förnamn är tom    
    public static boolean textFaltFornamn(JTextField rutaAttKolla) {
        boolean resultat = true;

        if (rutaAttKolla.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vänligen ange ett förnamn!");
            rutaAttKolla.requestFocus();
            resultat = false;
        }

        return resultat;
    }

//Metod för att kontrollera om inmatningsrutan för förnamn är tom    
    public static boolean textFaltEfternamn(JTextField rutaAttKolla) {
        boolean resultat = true;

        if (rutaAttKolla.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vänligen ange ett Efternamn!");
            rutaAttKolla.requestFocus();
            resultat = false;
        }

        return resultat;
    }

//Metod för att kontrollera att inmatningsrutan endast accepterar heltatsvärden för ID 
    public static boolean isHeltalID(JTextField rutaAttKolla) {
        boolean resultat = true;

        try {
            String inStrang = rutaAttKolla.getText();
            Integer.parseInt(inStrang);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Vänligen ange ett ID i formatet heltal!");
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

//Metod för att kontrollera så att användarnamnet är korrekt från det användaren matar in mot databasen     
    public boolean isUsernameCorrect(JTextField txtUsername) {
        boolean correctUsername = false;
        try {
            String svar = null;
            String fraga = "SELECT LAST_NAME FROM USERS WHERE LAST_NAME = '" + txtUsername.getText() + "';";
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

//Metod för att kontrollera så att lösenordet är korrekt från det användaren matar in mot databasen
    public boolean isPasswordCorrect(JTextField txtUsername, String txtPassword) {
        boolean passwordIsCorrect = true;

        try {
            String username = txtUsername.getText();
            String password = txtPassword;
            String correctPassword = "SELECT LOSENORD FROM USERS WHERE EMAIL = '" + username + "';";
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

//Metod för att kontrollera om användaren har superadmin behörighet
    public boolean isSuperAdminCorrect() {
        boolean isSuperAdmin = false;
        try {
            User u = User.getInstance(); //när man loggar in sätter man ID till den personen som loggar in
            int id = u.getID();          //här hämtar man ID från den personen som loggar in! När personen loggar ut blir ID = null
            String fraga = "SELECT TYPER FROM USERS WHERE USER_ID = '" + id + "';";
            String superadmin = idb.fetchSingle(fraga);
            if (superadmin.equals("SUPERADMIN")) {
                isSuperAdmin = true;
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
            System.out.println("Internt felmeddelande" + e.getMessage());
        }
        return isSuperAdmin;

    }

//Metod för att kontrollera om användaren har admin behörighet
    public boolean isAdminCorrect() {
        boolean isAdmin = false;
        try {
            User u = User.getInstance(); //när man loggar in sätter man ID till den personen som loggar in
            int id = u.getID();          //här hämtar man ID från den personen som loggar in! När personen loggar ut blir ID = null
            String fraga = "SELECT TYPER FROM USERS WHERE USER_ID = '" + id + "';";
            String admin = idb.fetchSingle(fraga);
            if (admin.equals("ADMIN")) {
                isAdmin = true;
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
            System.out.println("Internt felmeddelande" + e.getMessage());
        }
        return isAdmin;
    }

    //Metod för att kontrollera så att den email som matats in är korrekt från det användaren matar in mot databasen
    public boolean issEmailCorrect(JTextField txtMejladress) {
        boolean isEmailCorrect = true;

        try {
            String userEmail = txtMejladress.getText();
            System.out.println(userEmail + ".");
            String correctEmail = "SELECT EMAIL FROM USERS WHERE EMAIL = '" + userEmail + "';";
            String email = idb.fetchSingle(correctEmail);
            System.out.println(email + ".");

            if (!(email.equals(correctEmail))) {
                isEmailCorrect = false;
                JOptionPane.showMessageDialog(null, "Email finns inte. Försök igen");
            }

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
            System.out.println("Internt felmeddelande" + e.getMessage());
            isEmailCorrect = false;
        }
        return isEmailCorrect;
    }

    public boolean isEmailCorrect(JTextField epost) {
        try {
            String userEmail = epost.getText();
            System.out.println(userEmail + ".");
            String correctEmail = "SELECT EMAIL FROM USERS WHERE EMAIL = '" + userEmail + "';";
            String email = idb.fetchSingle(correctEmail);
            System.out.println(email + ".");

            if (userEmail.equals(email)) {
                System.out.println("true");
                return true;

            } else {
                System.out.println("false");
                return false;
            }
        } catch (InfException e) {
            System.out.println("false");
            return false;
        }
    }

    public static boolean isEmailFormatCorrect(JTextField epost) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        String mail = epost.getText();
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(mail);
        if (m.find()) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Ange en korrekt epost");
            epost.requestFocus();
            return false;
        }
    }

//Metod för att kolla om användar ID finns när man söker efter inlägg skapad av användare X
//Denna metod kan koperias för att validera alla ID sökningar i hela databasen
    public boolean isIdCorrect(JTextField txtnamn) {
        boolean rattId = false;
        try {
            String id = "SELECT USER_ID FROM USER;";
            ArrayList<String> userId = idb.fetchColumn(id);
            for (String ettId : userId) {
                if (ettId.equals(txtnamn.getText())) {
                    rattId = true;
                }
            }
            if (rattId == false) {
                JOptionPane.showMessageDialog(null, "Användarens ID hittades inte");
                txtnamn.requestFocus();
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
            System.out.println("Internt felmeddelande" + e.getMessage());
        }
        return rattId;
    }

    public boolean isProjektAgare(JComboBox<String> boxNamn) {
        boolean isAgare = false;
        try {
            String projektNamn = (String) boxNamn.getSelectedItem();
            System.out.println(projektNamn);
            User u = User.getInstance();
            int id = u.getID();
            String fraga = "SELECT PROJEKTNAMN FROM PROJEKT WHERE AGARE = " + id + ";";
            ArrayList<String> agare = idb.fetchColumn(fraga);
            if (agare == null) {
                isAgare = false;
                JOptionPane.showMessageDialog(null, "Ej behörig");
            }
            for (int i = 0; i < agare.size(); i++) {
                String ettProjekt = agare.get(i);
                
                if (ettProjekt.equals(projektNamn)) {
                    isAgare = true;

                }
            }

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Ej behörig");
        }
        return isAgare;
    }
    
    public boolean isProjektAgare(String projektnamn) {
        boolean isAgare = false;
        try {
            User u = User.getInstance();
            int id = u.getID();
            String fraga = "SELECT PROJEKTNAMN FROM PROJEKT WHERE AGARE = " + id + ";";
            ArrayList<String> agare = idb.fetchColumn(fraga);
            if (agare == null) {
                isAgare = false;
                JOptionPane.showMessageDialog(null, "Ej behörig");
            }
            for (int i = 0; i < agare.size(); i++) {
                String ettProjekt = agare.get(i);
                
                if (ettProjekt.equals(projektnamn)) {
                    isAgare = true;

                }
            }

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Ej behörig");
        }
        return isAgare;
    }

    //Kollar om lösenordet är i korrekt format
    public boolean passwordCorrectFormat(JPasswordField txtlosen) {
        char[] losen = txtlosen.getPassword();
        String password = new String(losen);
        if (password.length() >= 8) {
            Pattern letter = Pattern.compile("[a-zA-z]");
            Pattern digit = Pattern.compile("[0-9]");
            Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
            //Pattern eight = Pattern.compile (".{8}");

            Matcher hasLetter = letter.matcher(password);
            Matcher hasDigit = digit.matcher(password);
            Matcher hasSpecial = special.matcher(password);

            return hasLetter.find() && hasDigit.find() && hasSpecial.find();

        } else {
            return false;
        }
    }

    public boolean isMedIForskningProjekt(String projektnamnet) {
        boolean isMedlem = false;

        try {
            String fraga1 = "SELECT PROJEKT_ID FROM PROJEKT WHERE PROJEKTNAMN = '" + projektnamnet + "'";
            String projektID = idb.fetchSingle(fraga1);
            User u = User.getInstance();
            int id = u.getID();
            String stringId = Integer.toString(id);
            String fraga2 = "SELECT USER_ID FROM DELTAR_I_PROJEKT WHERE PROJEKT_ID = '" + projektID + "'";
            ArrayList<String> medlemmar = idb.fetchColumn(fraga2);
            if (medlemmar == null) {
                isMedlem = false;

            }
            for (int i = 0; i < medlemmar.size(); i++) {
                String enMedlem = medlemmar.get(i);

                if (enMedlem.equals(stringId)) {
                    isMedlem = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Du är inte medlem i detta projekt");
                }
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Du är inte medlem i detta projekt");
        }
        return isMedlem;
    }

    public boolean isMedIUtbildningProjekt(String projektnamnet) {
        boolean isMedlem = false;

        try {
            String fraga1 = "SELECT UTBILDNINGS_ID FROM UTBILDNING WHERE UTBILDNINGSNAMN = '" + projektnamnet + "'";
            String projektID = idb.fetchSingle(fraga1);
            User u = User.getInstance();
            int id = u.getID();
            String stringId = Integer.toString(id);
            String fraga2 = "SELECT USER_ID FROM DELTAR_I_UTBILDNING WHERE UTBILDNINGS_ID = '" + projektID + "'";
            ArrayList<String> medlemmar = idb.fetchColumn(fraga2);
            if (medlemmar == null) {
                isMedlem = false;

            }
            for (int i = 0; i < medlemmar.size(); i++) {
                String enMedlem = medlemmar.get(i);

                if (enMedlem.equals(stringId)) {
                    isMedlem = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Du är inte medlem i detta projekt");
                }
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Du är inte medlem i detta projekt");
        }
        return isMedlem;
    }

}
