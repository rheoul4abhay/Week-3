import SortingLargeDataEfficiently.SortingAlgorithmsRuntimeComparison;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortingAlgorithmsAnalysisTest {

    @Test
    void bubbleSortTest(){
        int[] dataset1k = new int[1000];
        for(int i = 999;i >= 0; i--) dataset1k[i] = i+1;
        int[] result = new int[1000];
        for(int i = 0; i <= 999;i++) result[i] = i+1;
        SortingAlgorithmsRuntimeComparison.bubbleSort(dataset1k);
        assertArrayEquals(result, dataset1k, "Dataset should be sorted!");
    }

    @Test
    void quickSortTest(){
        int[] dataset1k = new int[1000];
        for(int i = 999;i >= 0; i--) dataset1k[i] = i+1;
        int[] result = new int[1000];
        for(int i = 0; i <= 999;i++) result[i] = i+1;
        SortingAlgorithmsRuntimeComparison.mergeSort(dataset1k, 0, dataset1k.length-1);
        assertArrayEquals(result, dataset1k, "Dataset should be sorted!");
    }

    @Test
    void mergeSortTest(){
        int[] dataset1k = new int[1000];
        for(int i = 999;i >= 0; i--) dataset1k[i] = i+1;
        int[] result = new int[1000];
        for(int i = 0; i <= 999;i++) result[i] = i+1;
        SortingAlgorithmsRuntimeComparison.quickSort(dataset1k, 0, dataset1k.length-1);
        assertArrayEquals(result, dataset1k, "Dataset should be sorted!");
    }
}
