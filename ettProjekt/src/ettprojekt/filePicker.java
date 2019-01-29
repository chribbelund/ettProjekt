/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ettprojekt;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Christoffer
 */
public class filePicker {

    //Kör denna metod för att öppna en file picker. Den returnerar pathen till filen i en string
    public static boolean openFilePicker() {
        boolean msg = false;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss.SSS");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String fileName = f.getAbsolutePath();
        File inputFile = new File(fileName);
        System.out.println(dtf.format(now));
        String outputPath = System.getProperty("user.dir") + "/files/" + date + "-" + FilenameUtils.getName(fileName);
        System.out.println(outputPath);
        File outputFile = new File(outputPath);
        try {
            fileSave.copyFileUsingStream(inputFile, outputFile);
            msg = true;
            //string auto increment
            //insert into files (increment, outputPath)
        } catch (IOException ex) {
            Logger.getLogger(testFil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }
}
