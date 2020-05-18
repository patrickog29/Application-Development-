/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileinputoutput;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author PoG
 */
public class WriteCustomer {
    

        public static void main(String [] args)
    {
        Path target =Paths.get("customer2.dat");
        
        Scanner scan = new Scanner(System.in);
        
        int customer_number = 0;
        String name="";
        String Town="";
        String County="";
        
        String textForFile = "";
        String more = "y";
        
        try {
            
            System.out.println("Please enter Customer details");
            while (more.equals("y")) {
                System.out.println("Please enter the Customer Number");
                customer_number = scan.nextInt();
                
                // add the product number and a tab to the data to be written to the file
                textForFile += customer_number + "\t";
            
                System.out.println("Please enter the customer name");
                name = scan.next();
                
                // add the customer name and a tab to the data to be written to the file
                textForFile += name + "\t";
                
                System.out.println("Please enter the Town name");
                Town = scan.next();
                
                // add the Town name and a tab to the data to be written to the file
                textForFile += Town + "\t";
                
                System.out.println("Please enter the County name");
                County = scan.next();
                
                // add the County name and a tab to the data to be written to the file
                textForFile += County + "\n";
                
                
                scan.nextLine();

                System.out.println("Would you like to enter more data? (y/n)");
                more = scan.nextLine();
                
                more.toLowerCase();
            }
            Files.write(target, textForFile.getBytes());
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
            
        
    }
}