/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logging;

import com.itextpdf.text.Paragraph;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Priyanka
 */
public class LogReports {

    public void logReportCheck(String message) {
        BufferedWriter writer = null;
        try {
            //create a temporary file
            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            //String timeLog = "check";
                File logFile = new File("F:\\Alerts" + timeLog);

            // This will output the full path where the file will be written to...
            //  System.out.println(logFile.getCanonicalPath());
            writer = new BufferedWriter(new FileWriter(logFile, true));
            writer.write(timeLog +"\n"+message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
                System.out.println("File is closed");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void logUserData(String message, String name) {
        BufferedWriter writer = null;
        try {
            //create a temporary file
            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            //String timeLog = "check";
            //String fileName = name;

            File myOutputDir = new File("F:\\Alerts\\" + name);

            if (!myOutputDir.exists()) {
                myOutputDir.mkdir();
            }
            File logFile = new File(myOutputDir + "/" + name);
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile, true));
            writer.write(timeLog+"\n"+message +"\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
    }
}
