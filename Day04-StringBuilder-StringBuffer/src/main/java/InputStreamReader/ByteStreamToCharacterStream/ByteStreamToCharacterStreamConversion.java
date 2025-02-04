package InputStreamReader.ByteStreamToCharacterStream;

import javax.imageio.spi.IIOServiceProvider;
import java.io.*;

public class ByteStreamToCharacterStreamConversion {
    public static void main(String[] args) {
        String filePath = "src/main/java/input.txt";
        try(
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(inputStreamReader);
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bfw = new BufferedWriter(fileWriter);
        ) {
            System.out.println("Enter text ('exit') to stop: ");
            String userInput;
            while(!(userInput = bfr.readLine()).equalsIgnoreCase("exit")){
                bfw.write(userInput);
                bfw.newLine();
            }
            System.out.println("\nUser input saved to: " + filePath);
          } catch (IOException e){
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
