/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ettprojekt;

import static ettprojekt.EttProjekt.idb;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import oru.inf.InfException;

/**
 *
 * @author Christoffer
 */
public class base64Converter {

    public static String convertFile(String filePath) throws IOException, InfException {
        String fileName = FilenameUtils.getName(filePath);
        System.out.println(fileName);
        byte[] fileContent = FileUtils.readFileToByteArray(new File(filePath));
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
//        PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
//        writer.println(encodedString);
//        writer.close();
        String increment = idb.getAutoIncrement("FILER", "FIL_ID");
        String fraga = ("INSERT INTO FILER VALUES ('" + encodedString + "', '" + fileName + "', '" + increment + "');");
        PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
        writer.println(fraga);
        writer.close();
        idb.insert(fraga);
        return fraga;
    }

    public static void convertBase64(int fid) throws IOException, InfException {
        String encodedString = idb.fetchSingle("SELECT FIL FROM FILER WHERE FID ='" + fid + "';");
        String fileName = idb.fetchSingle("SELECT TEXT FROM FILER WHERE FID ='" + fid + "';");
        File outputFile = new File(fileName);
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        FileUtils.writeByteArrayToFile(outputFile, decodedBytes);

    }
}
