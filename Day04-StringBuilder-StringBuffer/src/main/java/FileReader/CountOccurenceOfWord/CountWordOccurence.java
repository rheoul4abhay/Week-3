package FileReader.CountOccurenceOfWord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWordOccurence {

    public static int wordFrequency(String[] line, String word){
        int count = 0;
        for(String s: line){
            if(s.equalsIgnoreCase(word.trim())) count++;
        }
        return count;
    }

    public static int totalWordFrequency(String filePath, String word){
        CountWordOccurence obj = new CountWordOccurence();
        int wordCount = 0;
        try(BufferedReader bfr = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = bfr.readLine()) != null){
                String[] wordsArray = line.split(" ");
                wordCount += wordFrequency(wordsArray, word);
            }
        } catch(IOException e){
            System.out.print("Error: " + e.getMessage());
        } finally{
            return wordCount;
        }
    }

    public static void main(String[] args) {

        String filePath = "src/main/java/sample2.txt";
        String word = "is";
        int result = CountWordOccurence.totalWordFrequency(filePath, word);
        System.out.print("\nWord count in file for " + word + ": " + result);
    }
}
