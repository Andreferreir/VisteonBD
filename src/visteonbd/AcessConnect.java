/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visteonbd;


import java.io.File;
import java.io.FileNotFoundException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import javax.swing.*;

/**
 *
 * @author ferre
 */
public class AcessConnect {
    public Connection connection ;
    String data ;
     AcessConnect() {   
         
          try {
            File myObj = new File("C:\\Users\\Public\\Paths\\Path.txt");
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
           Class.forName ("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
            connection= DriverManager.getConnection(data);//Establishing Connection
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "not connected");
            e.printStackTrace();
        }
    }
}
