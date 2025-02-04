package LinearSearch.FirstNegativeNumberIndex;

public class FirstNegativeNumberIndex {

    public static int firstNegativeIndex(int[] array){
        int n = array.length;
        for(int i = 0;i < n; i++){
            if(array[i] < 0) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,-4,5,6,-7,8,-9};
        int result = FirstNegativeNumberIndex.firstNegativeIndex(arr);
        System.out.println(result >= 0 ? "First negative element found at index : " + result : "No negative element found in the array.");
    }
}
