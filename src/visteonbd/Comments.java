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
import java.util.Scanner;

/**
 *
 * @author ferre
 */
public class Comments {
    public void SaveComents (String Received){
        String data = null;
        try {
            File myObj = new File("C:\\Users\\Public\\Paths\\PathComments.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }   
        myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
try{
    String x = System.getProperty("user.name");
    FileWriter fileWriter= new FileWriter(data, true);
    fileWriter.append(Received + "\t \t");
    fileWriter.append("Added by : " + x + "\n");
    fileWriter.close();
    
} catch (IOException e) {
   e.printStackTrace();
}
    }
}

