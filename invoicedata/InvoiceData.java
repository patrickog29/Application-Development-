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
public class InvoiceData {

    
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
            stat.execute("CREATE TABLE if not exists invoice(invoice_num integer, customer_num integer, payment DECIMAL(10,2))");
            stat.execute("INSERT into invoice VALUES(11731, 3175, 0)");
            stat.execute("INSERT into invoice VALUES(11732, 3176, 249.50)");
            stat.execute("INSERT into invoice VALUES(11733, 3175, 0)");
            
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
