/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileinputoutput;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

/**
 *
 * @author PoG
 */
public class ParseCustomer {
       public static void main(String[] args) throws IOException {
        //Declare file reader stream
        
        FileReader frs = null;
        
        //Declare streamTokenizer
        StreamTokenizer in = null;
        
        // three input file fields: invoice_number, customer_number
        //and payment
        
        int customer_number = 0;
        String name="";
        String Town="";
        String County="";
        
        try {
            //Create file input stream
            
            frs = new FileReader("customer2.dat");
            
            //Create a stream tokenizer wrapping file input stream
            in = new StreamTokenizer(frs);
            
            //Read first token
            in.nextToken();
            
            //Process a record
            while (in.ttype != StreamTokenizer.TT_EOF) {
                //Get customer nimber
                if (in.ttype == StreamTokenizer.TT_NUMBER)
                    customer_number = (int) in.nval;
                else
                        System.out.println("Bad file format");

                //Get name
                if (in.nextToken() == StreamTokenizer.TT_WORD)
                    name = (String) in.sval;
               else
                        System.out.println("Bad file format");
                
                //Get Town
                if (in.nextToken() == StreamTokenizer.TT_WORD)
                    Town = in.sval;
                else
                    System.out.println("Bad file format");
                
                 //Get County
                if (in.nextToken() == StreamTokenizer.TT_WORD)
                    County = in.sval;
                else
                    System.out.println("Bad file format");
                
                in.nextToken();
                
                System.out.println("Customer Number: " + customer_number);
                System.out.println("Customer Name: " + name);
                System.out.println("Customer Town: " + Town);
                System.out.println("Customer County: " + County);
                System.out.println("");
                System.out.println("");
                
        }
        
     
    }
    catch(FileNotFoundException ex) {
            System.out.println("File not found: customer.dat");
}
    catch (IOException ex) {
            System.out.println(ex.getMessage());
}
    finally {
    try{
        if(frs != null) frs.close();
    }
    catch(IOException ex) {
        System.out.println(ex);
    }
}
}
}
 
