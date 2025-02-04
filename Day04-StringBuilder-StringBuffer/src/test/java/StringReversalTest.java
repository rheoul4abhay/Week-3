import StringBuilder.StringReversal.StringReversal;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringReversalTest {

    @Test
    void test1(){
        StringReversal sr = new StringReversal();
        StringBuilder sb = new StringBuilder("Hello");
        String output1 = StringReversal.reverseString(sb);
        assertEquals(output1, "olleH");
    }

    @Test
    void test2(){
        StringReversal sr = new StringReversal();
        StringBuilder sb = new StringBuilder("Hello Java World");
        String output1 = StringReversal.reverseString(sb);
        assertEquals(output1, "dlroW avaJ olleH");
    }

    @Test
    void test3(){
        StringReversal sr = new StringReversal();
        StringBuilder sb = new StringBuilder("Hello");
        String output1 = StringReversal.reverseString(sb);
        assertEquals(output1, "olleh");
    }

}