/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visteonbd;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ferre
 */

public class Submit {
    VisteonUI visteonUI= new VisteonUI() ;
    AcessConnect acessConnect=new AcessConnect();
    
       public void SubmitAction(String LineRef , String prodLine ,String prodname , String Code, String Origin , String NxtStep , String Qt ,String UnitPrice , String user ){   
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy   HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
       
        String s =  dtf.format(now);
       
        try {  
        String Boards = "insert into Boards (Line, Prodline, ProdName, SerialRef, Origin, NxtStep, Qty, UnitPrice, CurrUser , Date)"
                + "values"
                + " ( '"+LineRef+"' , '"+prodLine+"' , '"+prodname+"' , '"+Code+"' ,  '"+Origin+"' , '"+NxtStep+"' , '"+Qt+"' , '"+UnitPrice+"' , '"+user+"' ,'"+s+"')"
                + "";
        
        Statement ps = acessConnect.connection.createStatement();
        ps.executeUpdate(Boards);
        
        } catch (SQLException ex) {
            Logger.getLogger(Submit.class.getName()).log(Level.SEVERE, null, ex);
        }                            
        
       
        try {
            acessConnect.connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Submit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
