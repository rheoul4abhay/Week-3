package StringBuilder.RemoveDuplicatesFromString;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicateCharacters {

    public static StringBuilder removeDuplicates(String str){
        StringBuilder sb = new StringBuilder();
        HashSet<Character> characterSet = new HashSet<>();

        String lowerCase = str.toLowerCase();
        for(int i = 0;i < str.length();i++){
            char letter = str.charAt(i);
            if(!characterSet.contains(Character.toLowerCase(letter))){
                sb.append(letter);
                characterSet.add(Character.toLowerCase(letter));
            }
        }
        return sb;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter a string: ");
        String str = scanner.nextLine();

        StringBuilder result = RemoveDuplicateCharacters.removeDuplicates(str);
        System.out.println(result);
        scanner.close();
    }
}