/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package fileinputoutput;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/**
 *
 * @author PoG
 */
public class ParseInvoice {
    
    /**Main method*/
    
    public static void main(String[] args) throws IOException {
        //Declare file reader stream
        
        FileReader frs = null;
        FileWriter fos = null;
        
        //Declare streamTokenizer
        StreamTokenizer in = null;
        PrintWriter out = null;
        
        // three input file fields: invoice_number, customer_number
        //and payment
        
        int invoice_number = 0;
        int customer_number = 0;
        double payment = 0;
        
        // variable to hold the total 
        double total = 0;

        
        try {
            //Create file input stream
            
            // Create file input and output streams
            
            frs = new FileReader("invoice2.dat");
            fos = new FileWriter("invoicetotals2.txt");
            
            //Create a stream tokenizer wrapping file input stream
            in = new StreamTokenizer(frs);
            out = new PrintWriter(fos);
            
            //Read first token
            in.nextToken();
            
            //Process a record
            while (in.ttype != StreamTokenizer.TT_EOF) {
                //Get invoice nimber
                if (in.ttype == StreamTokenizer.TT_NUMBER)
                    invoice_number = (int) in.nval;
                else
                        System.out.println("Bad file format");

                //Get customer number
                if (in.nextToken() == StreamTokenizer.TT_NUMBER)
                    customer_number = (int) in.nval;
               else
                        System.out.println("Bad file format");
                
                //Get payment
                if (in.nextToken() == StreamTokenizer.TT_NUMBER){
                    payment = in.nval;
                    total += payment; }
                else
                    System.out.println("Bad file format");
                
                in.nextToken();
                
                //Print out the details to a file
                System.out.println("Invoice Number: " + invoice_number);
                System.out.println("Customer Number: " + customer_number);
                System.out.println("Payment Number: " + payment);
                System.out.println("");
                System.out.println("");
                
          out.println("Invoice Number: " + invoice_number);
          out.println("Customer Number: " + customer_number);
          out.println("Payment Number: " + payment);
          out.println("");
          out.println("");
        }
        //output the total
         
          out.println("Total:           " + total);

     
    }
    catch(FileNotFoundException ex) {
            System.out.println("File not found: invoice.dat");
}
    catch (IOException ex) {
            System.out.println(ex.getMessage());
}
    finally {
    try{
        if(frs != null) frs.close();
        if (fos != null) fos.close();
    }
    catch(IOException ex) {
        System.out.println(ex);
    }
}
}
}
 


