/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ettprojekt;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Christoffer
 */
public class filePicker {

    //Kör denna metod för att öppna en file picker. Den returnerar pathen till filen i en string
    public static String openFilePicker() {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        return filename;
    }
}
