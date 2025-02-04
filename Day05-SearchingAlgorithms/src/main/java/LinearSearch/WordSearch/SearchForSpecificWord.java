package LinearSearch.WordSearch;

import java.util.Scanner;

public class SearchForSpecificWord {

    public static String searchForWord(String[] sentences, String word){
        for(String sentence: sentences){
            String[] str = sentence.split(" ");
            for(String s: str){
                if(s.equalsIgnoreCase(word)) return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the number of sentences: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] sentences = new String[n];
        System.out.print("\nEnter the sentences");
        for(int i = 0;i < n;i++){
            System.out.print("\nSentence " + (i+1) + " : ");
            sentences[i] = scanner.nextLine();
        }

        System.out.print("\nEnter the word to seach: ");
        String word = scanner.nextLine();

        String result = searchForWord(sentences, word);
        System.out.println(result);
    }
}
