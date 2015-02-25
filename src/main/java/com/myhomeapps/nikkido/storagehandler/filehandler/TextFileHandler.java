/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhomeapps.nikkido.storagehandler.filehandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Prifiz
 */
public class TextFileHandler {
    
    public static String fileToString(String fileName) {
        
        StringBuilder stringBuilder = new StringBuilder();
        Log log = LogFactory.getLog(TextFileHandler.class);
        
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while(scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
                stringBuilder.append("\n");
            }
        } catch(FileNotFoundException ex) {
            log.error("File '" + fileName + "' not found");
            log.error(ex.getMessage());
        }
        return stringBuilder.toString();
    }
}
