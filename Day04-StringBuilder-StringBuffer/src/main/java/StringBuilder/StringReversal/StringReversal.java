package StringBuilder.StringReversal;
import java.util.Scanner;

public class StringReversal {

    public static String reverseString(StringBuilder sb){
        sb.reverse();
        return String.valueOf(sb);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter a string: ");
        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        String reversedString = reverseString(sb);
        System.out.print(reversedString);
    }
}