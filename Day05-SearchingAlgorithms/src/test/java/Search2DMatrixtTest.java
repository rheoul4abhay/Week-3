import BinarySearch.SearchIn2DMatrix.Search2DMatrix;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Search2DMatrixtTest {

    @Test
    void test1(){
        int[][] arr = {{1,2,3}, {7,8,9},{11,12,13}};
        int target = 11;
        boolean expectedOutput = true;
        boolean actualOutput = Search2DMatrix.search2DMatrix(arr, target);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void test2(){
        int[][] arr = {{1,2,3}, {7,8,9},{11,12,13}};
        int target = 15;
        boolean expectedOutput = false;
        boolean actualOutput = Search2DMatrix.search2DMatrix(arr, target);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void test3(){
        int[][] arr = {{}};
        int target = 15;
        boolean expectedOutput = false;
        boolean actualOutput = Search2DMatrix.search2DMatrix(arr, target);
        assertEquals(expectedOutput, actualOutput);
    }
}
