/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ettprojekt;

import static ettprojekt.EttProjekt.idb;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import oru.inf.InfException;

/**
 *
 * @author Christoffer
 */
public class base64Converter {

    public void convertFile(String filePath) throws IOException, InfException {
        String fileName = FilenameUtils.getName(filePath);
        byte[] fileContent = FileUtils.readFileToByteArray(new File(filePath));
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        String increment = idb.getAutoIncrement("FIL", "FID");
        idb.insert("INSERT INTO FID VALUES ('" + increment + "', '" + fileName + "', '" + encodedString + "');");
    }

    public void convertBase64(int fid) throws IOException, InfException {
        String encodedString = idb.fetchSingle("SELECT FIL FROM FILER WHERE FID ='" + fid + "';");
        String fileName = idb.fetchSingle("SELECT TEXT FROM FILER WHERE FID ='" + fid + "';");
        File outputFile = new File(fileName);
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        FileUtils.writeByteArrayToFile(outputFile, decodedBytes);

    }
}
