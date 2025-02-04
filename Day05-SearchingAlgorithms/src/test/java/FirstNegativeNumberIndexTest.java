import LinearSearch.FirstNegativeNumberIndex.FirstNegativeNumberIndex;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstNegativeNumberIndexTest {
    @Test
    void test1(){
        int[] array = {1,2,-3,4,5};
        int expected = 2;
        int actual = FirstNegativeNumberIndex.firstNegativeIndex(array);
        assertEquals(expected, actual);
    }

    @Test
    void test2(){
        int[] array = {1,2,3,4,5};
        int expected = -1;
        int actual = FirstNegativeNumberIndex.firstNegativeIndex(array);
        assertEquals(expected, actual);
    }

    @Test
    void test3(){
        int[] array = {-1,2,-3,4,5};
        int expected = 0;
        int actual = FirstNegativeNumberIndex.firstNegativeIndex(array);
        assertEquals(expected, actual);
    }
}
