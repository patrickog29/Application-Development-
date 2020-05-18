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
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author PoG
 */
public class WriteProduct {
        public static void main(String [] args)
    {
        Path target =Paths.get("product2.dat");
        
        Scanner scan = new Scanner(System.in);
        
        String product_number = "";
        String product = "";
        double price = 0;
        
        String textForFile = "";
        String more = "y";
        
        try {
            
            System.out.println("Please enter product details");
            while (more.equals("y")) {
                System.out.println("Please enter the Product Code");
                product_number = scan.nextLine();
                
                // add the product number and a tab to the data to be written to the file
                textForFile += product_number + "\t";
            
                System.out.println("Please enter the product name");
                product = scan.nextLine();
                
                // add the product name and a tab to the data to be written to the file
                textForFile += product + "\t";
                
                System.out.println("Please enter the price amount");
                price = scan.nextDouble();
                
                // add the price and end of line to the data to be written to the file
                textForFile += price + "\n";
                
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
