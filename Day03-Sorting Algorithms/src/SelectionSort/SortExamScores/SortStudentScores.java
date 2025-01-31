package SelectionSort.SortExamScores;

public class SortStudentScores{

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void selectionSort(int[] arr){
        int n = arr.length;
        for(int i = 0;i < n-1;i++){
            int smallestIndex = i;
            for(int j = i+1;j < n;j++){
                if(arr[j] < arr[smallestIndex]){
                    smallestIndex = j;
                }
            }
            swap(arr, i, smallestIndex);
        }
    }

    public static void main(String[] args){
        int[] marks = {8,3,2,5,6,1};

        System.out.print("Original Array: ");
        for(int a: marks){
            System.out.print(a + " ");
        }
        selectionSort(marks);
        System.out.println();
        System.out.print("Sorted Array: ");
        for(int a: marks){
            System.out.print(a + " ");
        }
    }
}

