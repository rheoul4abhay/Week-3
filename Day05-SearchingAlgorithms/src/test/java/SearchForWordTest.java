import LinearSearch.WordSearch.SearchForSpecificWord;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchForWordTest {
    @Test
    void test1(){
        String[] sentences = {"This text contains information", "About some planets"};
        String word = "Earth";
        String expected = "Not Found";
        String actualOutput = SearchForSpecificWord.searchForWord(sentences, word);
        assertEquals(expected, actualOutput);
    }
    @Test
    void test2(){
        String[] sentences = {"This is some form of text", "which is so random"};
        String word = "random";
        String expected = "which is so random";
        String actualOutput = SearchForSpecificWord.searchForWord(sentences, word);
        assertEquals(expected, actualOutput);
    }
    @Test
    void test3(){
        String[] sentences = {"This is some form of text", "which is so random"};
        String word = "is";
        String expected = "This is some form of text";
        String actualOutput = SearchForSpecificWord.searchForWord(sentences, word);
        assertEquals(expected, actualOutput);
    }
}
