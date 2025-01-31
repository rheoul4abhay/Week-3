package CountingSort.SortStudentAges;
import java.util.Arrays;

public class SortStudentAges {

    public static void countSort(int[] arr){
        int n = arr.length;
        int m = findMax(arr);

        int[] count = new int[m+1];
        for(int i = 0;i < n;i++){
            count[arr[i] - 10]++;
        }
        int j = 0;
        int k = 0;
        while(j < count.length){
            while(count[j] > 0){
                arr[k++] = j+10;
                count[j]--;
            }
            j++;
        }
    }

    public static int findMax(int[] arr){

        int max = Integer.MIN_VALUE;
        for(int i = 0;i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[] age = {10, 18, 14, 15, 17, 12};
        System.out.print("Before sort: ");
        for(int a: age){
            System.out.print(a + " ");
        }
        System.out.println();
        countSort(age);
        System.out.print("After sort: ");
        for(int a: age){
            System.out.print(a + " ");
        }
    }
}
