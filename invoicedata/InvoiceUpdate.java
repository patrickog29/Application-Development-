/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicedata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pamela.obrien
 */
public class InvoiceUpdate {
    
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
            
            String command = "UPDATE invoice set payment = 150.75 where invoice_num = 11731";
            
            int count = stat.executeUpdate(command);
            System.out.println("The number of rows affected is " + count);
            
            ResultSet result = stat.executeQuery("SELECT * from invoice");
            
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
