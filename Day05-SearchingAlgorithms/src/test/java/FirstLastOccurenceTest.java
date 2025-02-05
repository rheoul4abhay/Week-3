import BinarySearch.FirstAndLastOccurence.FirstLastOccurence;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FirstLastOccurenceTest {

    @Test
    void test1(){
        int arr[] = {1,1,2,2,2,3,3,4,4,4,5,6,7,8,8,9};
        int target = 8;
        int[] expectedOutput = new int[]{13,14};
        int[] actualOutput = FirstLastOccurence.findFirstLastOccurence(arr, target);
        assertArrayEquals(expectedOutput, actualOutput, "Arrays are not equal!");
    }

    @Test
    void test2(){
        int arr[] = {};
        int target = 100;
        int[] expectedOutput = new int[]{-1, -1};
        int[] actualOutput = FirstLastOccurence.findFirstLastOccurence(arr, target);
        assertArrayEquals(expectedOutput, actualOutput, "Arrays are not equal!");
    }

    @Test
    void test3(){
        int arr[] = {1,2,2,3,4};
        int target = 5;
        int[] expectedOutput = new int[]{-1,-1};
        int[] actualOutput = FirstLastOccurence.findFirstLastOccurence(arr, target);
        assertArrayEquals(expectedOutput, actualOutput, "Arrays are not equal!");
    }
}
