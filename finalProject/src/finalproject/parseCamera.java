/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/**
 *
 * @author Patrick O Grady 
 * student No:K00245046
 */
public class parseCamera {
    
 public static void main(String[] args) throws IOException {
        //Declare file reader stream
        
        FileReader frs = null;
        FileWriter fos = null;
        
        //Declare streamTokenizer
        StreamTokenizer in = null;
        PrintWriter out = null;
        
        // 6 input file fields: BRand, Model, Colour, Megapixel, Price, New Price
        

      
        String brand = "";
        String model = "";
        String colour = "";
        int megapixel = 0;
        int price = 0;
        double newPrice = 0;
        
             
        
        // Creating the headings for the console output
                System.out.print("Brand" + "\t" + "\t");
                
                System.out.print("Model" + "\t" + "\t");
                
                System.out.print("Colour:" + "\t" + "\t");
                
                System.out.print("Megapixel" + "\t");
                
                System.out.print("Old Price" + "\t");
                
                System.out.println("New Price" + "\n");
                
                
                                                                    
                
        
        try {
            //Create file input stream
            
            // Create file input and output streams
            
           frs = new FileReader("stock.dat");
           fos = new FileWriter("newstock.dat");
            
            //Create a stream tokenizer wrapping file input stream
            in = new StreamTokenizer(frs);
            out = new PrintWriter(fos);
            
            
            // Create Headings for newstock.dat
                out.print("Brand" + "\t" + "\t");
                
                out.print("Model" + "\t" + "\t");
                
                out.print("Colour:" + "\t" + "\t");
                
                out.print("Megapixel" + "\t");
                
                out.print("Old Price" + "\t");
                
                out.println("New Price" + "\n");
                
         // Read past headings from stock file.   
        for (int i = 0; i < 5; i++){
        in.nextToken();
        
      }
        
            //Read first token
           in.nextToken();
            
            //Process a record
            while (in.ttype != StreamTokenizer.TT_EOF) {
                
                
                //Get the Brand
                if (in.ttype == StreamTokenizer.TT_WORD)
                    brand = (String) in.sval;
                else
                        System.out.print("Bad file format A");

                //Get the Model
                if (in.nextToken() == StreamTokenizer.TT_WORD)
                    model = (String) in.sval;
               else
                        System.out.print("Bad file format B");
                
                //Get the Colour
                if (in.nextToken() == StreamTokenizer.TT_WORD)
                    colour = (String) in.sval;
               else
                        System.out.print("Bad file format C");
                
                //Get Megapixels
                if (in.nextToken() == StreamTokenizer.TT_NUMBER)
                    megapixel = (int) in.nval;
                else
                        System.out.print("Bad file format D");
                
               //Get The Original Price
                if (in.nextToken() == StreamTokenizer.TT_NUMBER)
                    price = (int) in.nval;
                else
                        System.out.print("Bad file format E");
                     
                
                in.nextToken();
                
             
              
                
                //Print out the details to Console
                System.out.print(brand + "     \t");
                
                System.out.print(model + "     \t");
                
                System.out.print(colour + "\t" + "\t");
                
                System.out.print(megapixel + "\t"  + "\t");
                
                System.out.print(price + "\t"  + "\t");
                
                if (price >= 450){                                 //All prices greater than €450 -- 15%             //All rounded off with Math.round to round to nearest whole price
                    newPrice = price - (price * 0.15);
                     System.out.print(Math.round(newPrice)  + "\n");}
                
                else if (price >= 300 && price < 450){                 //All prices between €449 and €300 inclusive --- 12% 
                    newPrice = price - (price * 0.12);
                     System.out.print(Math.round(newPrice)  + "\n");}
                
                else if (price >= 200 && price < 300){                 // All prices between €299 and €200 inclusive --- 10% 
                    newPrice = price - (price * 0.10);
                     System.out.print(Math.round(newPrice)  + "\n");}
                
                else if (price >= 100 && price < 200){                 // All prices between €199 and €100 inclusive --- 8% 
                    newPrice = price - (price * 0.08);
                     System.out.print(Math.round(newPrice)  + "\n");}
                
                else if (price < 100){
                    newPrice = price - (price * 0.05);            //All prices less than €99 --- 5% 
                    System.out.print(Math.round(newPrice)  + "\n");}
             
               
                
                
            
                
                //Print out the details to a newstock.dat
                out.print(brand + "     \t");
                
                out.print(model + "     \t");
                
                out.print(colour + "\t" + "\t");
                
                out.print(megapixel + "\t"  + "\t");
                
                out.print(price + "\t"  + "\t");
                
                if (price >= 450){
                    newPrice = price - (price * 0.15);
                     out.print(Math.round(newPrice)  + "\n");}
                
                else if (price >= 300 && price < 450){
                    newPrice = price - (price * 0.12);
                     out.print(Math.round(newPrice) + "\n");}
                
               else if (price >= 200 && price < 300){
                    newPrice = price - (price * 0.10);
                     out.print(Math.round(newPrice) + "\n");}
                
               else if (price >= 100 && price < 200){
                    newPrice = price - (price * 0.08);
                     out.print(Math.round(newPrice)  + "\n");}
                
               else if (price < 100){
                    newPrice = price - (price * 0.05);
                    out.print(Math.round(newPrice)  + "\n");}
                
       
               
        //output the total
         


                        }
    }
    catch(FileNotFoundException ex) {
            System.out.println("File not found: stock.dat");
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
 