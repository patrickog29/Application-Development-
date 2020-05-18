/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author Patrick O Grady 
 * student No:K00245046
 */
public class writeCamera {
        public static void main(String [] args)
    {
        Path target =Paths.get("stock.dat");
        
        Scanner scan = new Scanner(System.in);
       
        
        String brand = "";
        String model = "";
        String colour = "";
        String megapixel = "";
        int price = 0;
        
        String textForFile = "";
        String more = "y";
        
        textForFile += "Brand" + "\t" + "\t";
        textForFile += "Model" + "\t";
        textForFile += "Colour" + "\t";
        textForFile += "Megapixel" + "\t";
        textForFile += "Price" + "\n";
        
        
        try {
            
            System.out.println("Please enter stock details");
            while (more.equals("y")) {
                System.out.println("Please enter the brand name");
                brand = scan.next();
                
                // add the invoice number and a tab to the data to be written to the file
                textForFile += brand + "\t";
            
                System.out.println("Please enter the model");
                model = scan.next();
                
                // add the cutomer number and a tab to the data to be written to the file
                textForFile += model + "\t";
                
                System.out.println("Please enter the colour");
                colour = scan.next();
                
                // add the payment and end of line to the data to be written to the file
                textForFile += colour + "\t";
                
                System.out.println("Please enter the megapixel amount");
                megapixel = scan.next();
                
                // add the payment and end of line to the data to be written to the file
                textForFile += megapixel + "\t" + "\t";
                
                System.out.println("Please enter the price amount");
                price = scan.nextInt();
                
                // add the payment and end of line to the data to be written to the file
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
        
    