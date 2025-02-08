package LargeFileReadingEfficiency;
import java.io.*;

public class FileReaderInputStreamReaderComparison {

    public static void manageFileReaderBySize(String filePath, String size){

        long startTime1 = System.nanoTime();
        try(FileReader fr = new FileReader(filePath)){
            int letter;
            while((letter = fr.read()) != -1){
            }
            System.out.println("\nFile read successfully using file reader!");
        } catch(IOException e){
            System.out.print("\nError while reading file: " + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long duration1 = endTime1 - startTime1;

        long startTime2 = System.nanoTime();
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "UTF-8")){
            int letter = -1;
            while((letter = isr.read()) != -1){
            }
            System.out.print("\nFile reading successfully using input stream reader!");
        } catch(IOException e){
            System.out.print("\nError while reading file: " + e.getMessage());
        }
        long endTime2 = System.nanoTime();
        long duration2 = endTime2-startTime2;

        System.out.print("\n------Comparison result for " + size + " Mb file------");
        System.out.print("\nTime taken by file reader -> " + duration1 / 1000000.0 + " ms");
        System.out.println("\nTime taken by inputstream reader -> " + duration2 / 1000000.0 + " ms");
        System.out.println();
    }

    public static void main(String[] args) {

        String filepath1 = "src/main/java/LargeFileReadingEfficiency/1mb-examplefile-com.txt"; //1Mb filepath
        manageFileReaderBySize(filepath1, "1");
        //manageFileReaderBySize(filepath2, "100");
        //manageFileReaderBySize(filepath3, "500");
    }
}
