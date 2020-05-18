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
import java.text.DecimalFormat;

/**
 * @author Patrick O Grady 
 * student No:K00245046
 */
public class parseWeather {

    
    
    public static void main(String[] args) throws IOException {
        //Declare file reader stream
        
        FileReader frs = null;
        FileWriter fos = null;
        
        //Declare streamTokenizer
        StreamTokenizer in = null;
        PrintWriter out = null;
        
        // 5 input file fields: County, Max, Min, Conditions, Average
        
        
       DecimalFormat df = new DecimalFormat("#.#");     //Method sets decimal place to 1 for output of average Daily Temps
       
        String county = "";
        double max = 0;
        double min = 0;
        String condition = "";
        double average = 0;
             
        
        // Creating the headings for the console output
                System.out.print("County" + "\t" + "\t");
                
                System.out.print("Max" + "\t" + "\t");
                
                System.out.print("Min:" + "\t");
                
                System.out.print("Condition" + "\t");
                
                System.out.print("Average Daily" + "\t");
                
                System.out.println("Freeze Risk" + "\n");
                
                
        
        try {
            //Create file input stream
            
            // Create file input and output streams
            
           frs = new FileReader("weather.dat");
           fos = new FileWriter("averagetemps.dat");
            
            //Create a stream tokenizer wrapping file input stream
            in = new StreamTokenizer(frs);
            out = new PrintWriter(fos);
            
            
            // Create Headings for averagetemps.dat
                out.print("County" + "\t" + "\t");
                
                out.print("Average Daily" + "\t");
                
                out.println("Freeze Risks" + "\n");
       
           
            // Read past headings from stock file. 
            for (int i = 0; i < 4; i++){
              in.nextToken();

      }
        
            //Read first token
            in.nextToken();
            
            //Process a record
            while (in.ttype != StreamTokenizer.TT_EOF) {
                //Get County
                if (in.ttype == StreamTokenizer.TT_WORD)
                    county = (String) in.sval;
                else
                        System.out.print("Bad file format A");

                //Get max value
                if (in.nextToken() == StreamTokenizer.TT_NUMBER)
                    max = (int) in.nval;
               else
                        System.out.print("Bad file format B");
                
                //Get min value
                if (in.nextToken() == StreamTokenizer.TT_NUMBER)
                    min = (int) in.nval;
               else
                        System.out.print("Bad file format C");
                //Get Condition
                if (in.nextToken() == StreamTokenizer.TT_WORD)
                    condition = (String) in.sval;
                else
                        System.out.print("Bad file format D");
                       System.out.println("");
                
                
                in.nextToken();
                
              
                
               
              
                
                //Print out the details to a file
                System.out.print(county + "     \t");
                
                System.out.print(max + "\t" + "\t");
                
                System.out.print(min + "\t");
                
                System.out.print(condition + "\t" + "\t");
                
                System.out.print(df.format((average=(min + max)/2)) + "\t" + "\t");  //Average Temperatures  set to one decimal place
                
                if (average <= 0){                                      //Freeze Risk
                     System.out.print("Yes"  + "\t");}
                else{
                    System.out.print("No"  + "\t");};
                
                
            
                
                //Print out the details to a file averagetemps.txt
                out.print(county + "     \t");
                  
                out.print(df.format((average=(min + max)/2)) + "\t" + "\t");  //Average Temperatures set to one decimal place
                
                if (average <= 0){                                      //Freeze Risk
                     out.println("Yes"  + "\n");}
                else{
                    out.println("No"  + "\n");};     
        }
               
        //output the total
         


     
    }
    catch(FileNotFoundException ex) {
            System.out.println("File not found: weather.dat");
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
 