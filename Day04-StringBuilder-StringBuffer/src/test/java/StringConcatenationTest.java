import StringBuffer.ConcatenateString.StringConcatenation;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringConcatenationTest {

    @Test
    void test1(){
        String[] stringArray = {"Hello", "Java", "World"};
        String expectedOutput = "HelloJavaWorld";
        String output = StringConcatenation.concatenateString(stringArray);
        assertEquals(expectedOutput, output);
    }

    @Test
    void test2(){
        String[] stringArray = {"Legends", "   never", "   die"};
        String expectedOutput = "Legendsneverdie";
        String output = StringConcatenation.concatenateString(stringArray);
        assertEquals(expectedOutput, output);
    }

    @Test
    void test3(){
        String[] stringArray = {"Hello", "World"};
        String expectedOutput = "Helloworld";
        String output = StringConcatenation.concatenateString(stringArray);
        assertEquals(expectedOutput, output);
    }

}