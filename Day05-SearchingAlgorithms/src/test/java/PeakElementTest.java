import BinarySearch.FindPeakElement.PeakElement;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PeakElementTest {

    @Test
    void test1(){
        int[] arr = {1,2,3,4,5};
        int expectedOutput = Integer.MAX_VALUE;
        int actualOutput = PeakElement.findPeakElement(arr);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void test2(){
        int[] arr = {};
        int expectedOutput = Integer.MAX_VALUE;
        int actualOutput = PeakElement.findPeakElement(arr);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void test3(){
        int[] arr = {1,2,1,5,4};
        int expectedOutput = 2;
        int actualOutput = PeakElement.findPeakElement(arr);
        assertEquals(expectedOutput, actualOutput);
    }
}
