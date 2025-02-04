import FileReader.CountOccurenceOfWord.CountWordOccurence;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountTest {

    @Test
    void test1(){
        String word = "earth  ";
        int expected = 5;
        int actualOutput = CountWordOccurence.totalWordFrequency("src/main/java/sample2.txt", word);
        assertEquals(expected, actualOutput);
    }

    @Test
    void test2(){
        String word = "is";
        int expected = 4;
        int actualOutput = CountWordOccurence.totalWordFrequency("src/main/java/sample2.txt", word);
        assertEquals(expected, actualOutput);
    }
}
