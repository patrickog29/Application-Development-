/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicedata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author pamela.obrien
 */
public class InvoiceQueries {
  
         public static void main(String[] args) throws SQLException {
        
        String URL = "jdbc:mysql://localhost:3306/";
        String DB = "appdev";
        String USERNAME = "root";
        String PASSWORD = "";
        
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection(URL+DB, USERNAME, PASSWORD);
            System.out.println("Connected");
            Statement stat = conn.createStatement();
            
            String query = "SELECT * from invoice where invoice_num = ?";
            String accountNumber = "11731";
            
            PreparedStatement prepareStat = (PreparedStatement) conn.prepareStatement(query);
            
            prepareStat.setString(1,accountNumber);
            
            ResultSet result = prepareStat.executeQuery();
            
            while(result.next()) 
            {
            
                System.out.println("Invoice number " + result.getString("invoice_num"));
                System.out.println("Customer number " + result.getString("customer_num"));  
                System.out.println("Payment " + result.getString("payment"));       
            }
            
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        finally
        {
            if (conn != null)
            {
                conn.close();
            }
        }
    }
}
