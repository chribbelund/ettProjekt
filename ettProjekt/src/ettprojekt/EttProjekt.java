/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ettprojekt;

import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Christoffer
 */
public class EttProjekt {

    public static String userDir;
    public static InfDB idb;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        userDir = System.getProperty("user.dir"); //Hämtar vart programmet körs ifrån
        userDir += "/lib/DATABASE.FDB"; //Pekar på vart databasen ligger lagrad
        try {
            //Importerar databasen
            idb = new InfDB(EttProjekt.userDir);
            new informellblogg().setVisible(true);//Startar programmet genom att köra valElevLarare.java
            System.out.println(userDir);  
        } catch (InfException undantag) {
            JOptionPane.showMessageDialog(null, "Programmet kan ej ansluta till databasen");
            System.out.println("Internt felmeddelande" + undantag.getMessage());
            System.out.println(userDir);
        }
        
    }

}
