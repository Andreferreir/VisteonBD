/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visteonbd;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ferre
 */

public class DeleteLast {
    AcessConnect acessConnect=new AcessConnect();
    public void Delete(String name) throws SQLException {

        String query = ("DELETE * FROM Boards WHERE (ID=(SELECT MAX(id) FROM Boards) AND CurrUser= '"+name+"' ) ");
        Statement ps = acessConnect.connection.createStatement();
        
        if(ps.executeUpdate(query)== 0){
            JOptionPane.showMessageDialog(null,
            "Row not deleted!",
            "FATAL ERROR",
            JOptionPane.ERROR_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null,
            "Row deleted!",
            "SUCCESS",
            JOptionPane.INFORMATION_MESSAGE);
        }
    }   
}
