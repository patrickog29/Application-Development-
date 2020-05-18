/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicedata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author pamela.obrien
 */
public class InvoicePreparedStatement {

    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the invoice number");
        int invoice_num = scan.nextInt();
        System.out.println("Please enter the customer number");
        int customer_num = scan.nextInt();
        System.out.println("Please enter the payment amount");
        double payment = scan.nextDouble();

        String URL = "jdbc:mysql://localhost:3306/";
        String DB = "appdev";
        String USERNAME = "root";
        String PASSWORD = "";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL + DB, USERNAME, PASSWORD);
            System.out.println("Connected");
            
            String command = "INSERT into invoice VALUES (?,?,?)";
           
            PreparedStatement prepareStat = (PreparedStatement) conn.prepareStatement(command);
            
            prepareStat.setInt(1,invoice_num);
            prepareStat.setInt(2,customer_num);
            prepareStat.setDouble(3,payment);
            
            prepareStat.execute();
            
      
            
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

}
