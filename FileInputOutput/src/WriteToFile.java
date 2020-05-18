import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PoG
 */
public class WriteToFile {
    
    public static void main(String[] args) {
        
        Path target = Paths.get("C:\\myfolder\\writeFile.txt");
        Scanner scan = new Scanner(System.in);
        String lineOfText = "";
        String textForFile= "";
        String more = "y";
        
        try {
            while (more.equals("y")) {
                System.out.println("Please enter a line of text to add to the file");
                lineOfText = scan.nextLine();
                
                textForFile += lineOfText + "\n";
                
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
