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
public class ParseProduct {
           public static void main(String[] args) throws IOException {
        //Declare file reader stream
        
        FileReader frs = null;
        
        //Declare streamTokenizer
        StreamTokenizer in = null;
        
        // three input file fields: invoice_number, customer_number
        //and payment
        
        String product_number= "";
        String product= "";
        double price= 0;
        
        
        try {
            //Create file input stream
            
            frs = new FileReader("product2.dat");
            
            //Create a stream tokenizer wrapping file input stream
            in = new StreamTokenizer(frs);
            
            //Read first token
            in.nextToken();
            
            //Process a record
            while (in.ttype != StreamTokenizer.TT_EOF) {
                //Get product nimber
                if (in.ttype == StreamTokenizer.TT_WORD)
                    product_number = (String) in.sval;
                else
                        System.out.println("Bad file format");

                //Get product
                if (in.nextToken() == StreamTokenizer.TT_WORD)
                    product = (String) in.sval;
               else
                        System.out.println("Bad file format");
                
                //Get payment
                if (in.nextToken() == StreamTokenizer.TT_NUMBER)
                    price = in.nval;
                else
                    System.out.println("Bad file format");

                
                in.nextToken();
                
                System.out.println("Product Number: " + product_number);
                System.out.println("Product: " + product);
                System.out.println("Price: " + price);
  
                System.out.println("");
                System.out.println("");
                
        }
        
     
    }
    catch(FileNotFoundException ex) {
            System.out.println("File not found: product.dat");
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
