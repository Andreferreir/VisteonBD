/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visteonbd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


/**
 *
 * @author ferre
 */
public class Logs {
    
    public void insertLog () throws IOException
    {
        String data= null;
        
        try {
            File myObj = new File("C:\\Users\\Public\\Paths\\pathLogs.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }   
        myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
    String x = System.getProperty("user.name");
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();  
    String Received = dtf.format(now);
    FileWriter fileWriter= new FileWriter(data, true);
    fileWriter.append(Received + "\t \t");
    fileWriter.append("added by : " + x + "\n");
    fileWriter.close();
    }
}