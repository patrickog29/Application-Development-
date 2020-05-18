
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PoG
 */
public class weather {
    
        /**Main method*/
  public static void main(String[] args) {
    // Declare file reader and writer streams
    FileReader frs = null;
    FileWriter fws = null;

    // Declare streamTokenizer
    StreamTokenizer in = null;

    // Declare a print stream
    PrintWriter out = null;

    // temp location of the car
    String location = "";
    
    // temp vars for avg computation
    double ClareAverage = 0;
    double corkAverage = 0;
    double LimerickAverage = 0;
    double TipperaryAverage= 0;
    double WaterfordAverage = 0;
    double KerryAverage = 0;

    
    
    try     {
      // Create file input and output streams
      frs = new FileReader("weather.dat");
      fws = new FileWriter("weather2.txt");

      // Create a stream tokenizer wrapping file input stream
      in = new StreamTokenizer(frs);
      out = new PrintWriter(fws);

      //Set the - character as a "ordinary" char
      //This means the car reg will be available as 5 tokens
      //For example: 06-L-969 
      in.ordinaryChar('-');
      
      // Read past the 4 col headings
      for (int i = 0; i < 4; i++){
        in.nextToken();
      }
      
      // Process a record
      while (in.ttype != StreamTokenizer.TT_EOF)     {
          

        in.nextToken();  
        if (in.ttype == StreamTokenizer.TT_WORD)
            location = in.sval;
        else
            System.out.println("Bad file structure");
       
        //read TENTH token (PRICE OF CAR)
        in.nextToken(); 
        if (in.ttype != StreamTokenizer.TT_NUMBER)
          System.out.println("Bad file structure");
      
    
        //read ELEVENTH token (OWNERS OF CAR)
        in.nextToken();            

        //read TWELFTH token (MILEAGE OF CAR)
        in.nextToken();  
        
        //read next token of the next line in the file
        in.nextToken();  
      }
      
      
      
      //compute avg prices in the three locations
 /*     limerickAvg = limerickTotal / limerickCount;
      dublinAvg = dublinTotal / dublinCount;
      corkAvg = corkTotal / corkCount;   */
      
      //print info to second file
      out.println("Location    \tTotal Amount of Cars per County");
      out.println("Limerick Count    " + "\t " + limerickCount);
      out.println("Limerick Total    " + "\t " + limerickTotal);
      out.println("");
      out.println("Dublin count      " + "\t " + dublinCount);
      out.println("Dublin Total      " + "\t " + dublinTotal);
      out.println("");
      out.println("Cork count      " + "\t " + corkCount);
      out.println("Cork Total      " + "\t " + corkTotal);
      out.println("");
      
      
      
      System.out.println("Parsing file complete  - check projections.dat for summary information");

    }
    catch (FileNotFoundException ex)   {
      System.out.println("File not found: in.dat");
    }
    catch (IOException ex)   {
      System.out.println(ex.getMessage());
    }
    finally   {
      try     {
        if (frs != null) frs.close();
        if (fws != null) fws.close();
      }
      catch (IOException ex)  {
        System.out.println(ex);
      }
    }
  }
}

