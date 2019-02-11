/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ettprojekt;

import static ettprojekt.EttProjekt.idb;
import static ettprojekt.EttProjekt.userDir;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author EmelieD
 */
public class ComboBox {

    private static InfDB idb;

    public static void cboxLaggTillProjekt(JComboBox cboxKurs) {

        try {
            //Importerar databasen
            idb = new InfDB(userDir);
        } catch (InfException undantag) {
            JOptionPane.showMessageDialog(null, "Programmet kan ej ansluta till databasen");
            System.out.println("Internt felmeddelande" + undantag.getMessage());
            System.out.println(userDir);
        }
        try {
            //Hämtar alla kursnamn
            String fraga = "SELECT PROJEKTNAMN FROM PROJEKT;";
            ArrayList<String> projektlista = idb.fetchColumn(fraga);
            cboxKurs.removeAllItems();
            for (String currentProjekt : projektlista) {
                //Loopar igenom alla kursnamn och lägger till dem i den valda Comboboxen
                cboxKurs.addItem(currentProjekt);
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
            System.out.println("Internt felmeddelande" + e.getMessage());
        }

    }

    public static void cboxLaggTillEmail(JComboBox cboxKurs) {

        try {
            //Importerar databasen
            idb = new InfDB(userDir);
        } catch (InfException undantag) {
            JOptionPane.showMessageDialog(null, "Programmet kan ej ansluta till databasen");
            System.out.println("Internt felmeddelande" + undantag.getMessage());
            System.out.println(userDir);
        }
        try {
            //Hämtar alla kursnamn
            String fraga = "SELECT EMAIL FROM USERS;";
            ArrayList<String> mail = idb.fetchColumn(fraga);
            cboxKurs.removeAllItems();
            for (String currentMail : mail) {
                //Loopar igenom alla kursnamn och lägger till dem i den valda Comboboxen
                cboxKurs.addItem(currentMail);
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
            System.out.println("Internt felmeddelande" + e.getMessage());
        }

    }

}
