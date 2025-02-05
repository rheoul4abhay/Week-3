import BinarySearch.FindRotationPoint.FindRotationPoint;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotationPointTest {

    @Test
    void test1(){
        int[] arr = {1,2,3,4,5};
        int expectedOutput = 0;
        int actualOutput = FindRotationPoint.binarySearch(arr);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void test2(){
        int[] arr = {};
        int expectedOutput = -1;
        int actualOutput = FindRotationPoint.binarySearch(arr);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void test3(){
        int[] arr = {4,5,1,2,3};
        int expectedOutput = 2;
        int actualOutput = FindRotationPoint.binarySearch(arr);
        assertEquals(expectedOutput, actualOutput);
    }
}
