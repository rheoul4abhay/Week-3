package StringBuffer.ConcatenateString;
import java.util.Scanner;

public class StringConcatenation {

    public static String concatenateString(String[] arr){
        StringBuffer sbfr = new StringBuffer();
        for(String s: arr){
            sbfr.append(s.trim());
        }
        return String.valueOf(sbfr);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter size of string array : ");
        int size = scanner.nextInt();
        String[] arr = new String[size];
        scanner.nextLine();
        for(int i = 0;i < size;i++){
            System.out.print("Enter string element " + (i+1) + ": ");
            String input = scanner.nextLine().trim();
            arr[i] = input;
        }

        String concatenatedString = concatenateString(arr);
        System.out.println("Concatenated String: " + concatenatedString);
        scanner.close();
    }
}
