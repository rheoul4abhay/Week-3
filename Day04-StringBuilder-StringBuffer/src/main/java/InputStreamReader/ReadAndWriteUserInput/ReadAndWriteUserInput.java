package InputStreamReader.ReadAndWriteUserInput;

import java.io.*;

public class ReadAndWriteUserInput {
    public static void main(String[] args) {
        String filePath = "src/main/java/demo.txt";

        try(BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))){
            String line;
            while((line = bfr.readLine()) != null){
                System.out.println(line);
            }
        }

        catch(UnsupportedEncodingException e){
            System.out.println("\nError reading file: " + e.getMessage());
        }
        catch(FileNotFoundException e){
            System.out.println("\nError reading file: " + e.getMessage());
        }
        catch(IOException e){
            System.out.println("\nError reading file: " + e.getMessage());
        }
    }
}
