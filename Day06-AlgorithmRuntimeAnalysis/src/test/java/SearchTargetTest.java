import SearchTargetInDataset.SearchTargetComparison;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SearchTargetTest {

    //test linear search for small dataset
    @Test
    void testLinearSearch(){
        int[] dataset = new int[1000];
        for(int i = 0;i < dataset.length;i++) dataset[i] = i+1;
        int target = 50;
        int result = SearchTargetComparison.linearSearch(dataset, target);
        assertEquals(49, result, "Target should be found at index 49");
    }

    //test linear search for a target not present in dataset
    @Test
    void testLinearSearch_TargetNotFound(){
        int[] dataset = new int[1000];
        for(int i = 0;i < dataset.length;i++) dataset[i] = i+1;
        int target = 5000;
        int result = SearchTargetComparison.linearSearch(dataset, target);
        assertEquals(-1, result, "Target should not be found in dataset");
    }

    //Test binary search for small dataset
    @Test
    void testBinarySearch(){
        int[] dataset = new int[1000];
        for(int i = 0;i < dataset.length;i++) dataset[i] = i+1;
        int target = 50;
        int result = SearchTargetComparison.binarySearch(dataset, target);
        assertEquals(49, result, "Target should be found at index 49");
    }

    //Test binary search for a target not present in the dataset
    @Test
    void testBinarySearch_TargetNotFound(){
        int[] dataset = new int[1000];
        for(int i = 0;i < dataset.length;i++) dataset[i] = i+1;
        int target = 5000;
        int result = SearchTargetComparison.linearSearch(dataset, target);
        assertEquals(-1, result, "Target should not be found in dataset");
    }

    //Test both linear n binary search for same dataset
    @Test
    void testSearchComparison(){
        int[] dataset = new int[1000];
        for(int i = 0;i < 1000;i++) dataset[i] = i+1;
        int target = 50;
        int linearResult = SearchTargetComparison.linearSearch(dataset, target);
        assertEquals(49, linearResult, "Linear search should find target at index 49");
        int binaryResult = SearchTargetComparison.binarySearch(dataset, target);
        assertEquals(49, binaryResult, "Binary Search should find target at index 49");
    }
}
