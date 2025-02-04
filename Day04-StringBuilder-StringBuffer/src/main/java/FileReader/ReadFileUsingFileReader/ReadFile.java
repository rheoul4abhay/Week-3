package FileReader.ReadFileUsingFileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String filePath = "src/main/java/sample.txt";
        try(BufferedReader bfr = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = bfr.readLine()) != null){
                System.out.println(line);
            }
        } catch(IOException e){
            System.out.println("\nError reading the file! Error: " + e.getMessage());
        }
    }
}
