import StringBuilder.RemoveDuplicatesFromString.RemoveDuplicateCharacters;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicateCharactersTest {

    @Test
    void test1(){
        String str = "Hello World";
        StringBuilder result = RemoveDuplicateCharacters.removeDuplicates(str);
        assertEquals(result.toString(), "Helo Wrd");
    }

    @Test
    void test2(){
        String str = "Elon Musk";
        StringBuilder result = RemoveDuplicateCharacters.removeDuplicates(str);
        assertEquals(result.toString(), "Elon Musk");
    }

    @Test
    void test3(){
        String str = "Transition";
        StringBuilder result = RemoveDuplicateCharacters.removeDuplicates(str);
        assertEquals(result.toString(), "Transio");
    }
}