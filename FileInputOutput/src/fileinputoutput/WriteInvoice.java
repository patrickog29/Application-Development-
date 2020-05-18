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
public class WriteInvoice {
        public static void main(String [] args)
    {
        Path target =Paths.get("invoice2.dat");
        
        Scanner scan = new Scanner(System.in);
        
        int invoiceNum = 0;
        int customerNum = 0;
        double payment = 0;
        
        String textForFile = "";
        String more = "y";
        
        try {
            
            System.out.println("Please enter invoice details");
            while (more.equals("y")) {
                System.out.println("Please enter the invoice number");
                invoiceNum = scan.nextInt();
                
                // add the invoice number and a tab to the data to be written to the file
                textForFile += invoiceNum + "\t";
            
                System.out.println("Please enter the customer number");
                customerNum = scan.nextInt();
                
                // add the cutomer number and a tab to the data to be written to the file
                textForFile += customerNum + "\t";
                
                System.out.println("Please enter the payment amount");
                payment = scan.nextDouble();
                
                // add the payment and end of line to the data to be written to the file
                textForFile += payment + "\n";
                
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
