/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency;

import java.util.Random;

/**
 *
 * @author PoG
 */
public class RandomNumbersAndWords {

    public static void main(String[] args) {
        new GenerateRandomWords(6,500).start();                // Passed in length and number of words
        new GenerateRandomNumbers(10000, 5000, 700).start();   // contains Upperbound, lowerbound and the number output numbers
    }//end main()
    
}//end class RandomNumbersAndWords


class GenerateRandomWords extends Thread {

    int wordSize;
    int numberOfWords;
    char alphabet[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    
    public GenerateRandomWords(int wordSize, int numberOfWords) {
        
        this.wordSize = wordSize;
        this.numberOfWords = numberOfWords;
    }
    
    
    @Override
    public void run() {
        
        Random r = new Random();
        String aWord = "";
        
        for (int j = 0; j < numberOfWords; j++) {
            for (int i = 0; i <= 5; i++) { 
                aWord += String.valueOf(alphabet[r.nextInt(26)]);
            }//end inner for

            System.out.println(aWord);

            aWord = "";

        }//end outer for
    }//end run
}//end class GenerateRandomWords

////////////////////////////////////////////////////////////////////////////////

class GenerateRandomNumbers extends Thread {
    
    int upperBound;
    int lowerBound;
    int numberOfValues;

    Random r = new Random();
    
    public GenerateRandomNumbers(int upperBound, int lowerBound, int numberOfValues) {
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
        this.numberOfValues = numberOfValues;
    }
    
    @Override
    public void run() {
    
        int randNum = 0;
        
        for (int i =0; i < numberOfValues; i++) {
            randNum = r.nextInt(upperBound - lowerBound) + lowerBound;
            System.out.println(randNum);
        }//end for
    
    }//end run()
}//end class GenerateRandomNumbers

