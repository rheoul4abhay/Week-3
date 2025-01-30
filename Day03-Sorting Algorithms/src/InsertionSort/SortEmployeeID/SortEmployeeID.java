package InsertionSort.SortEmployeeID;

public class SortEmployeeID {

    public static void insertionSort(int[] arr){
        int n = arr.length;
        for(int i = 0;i <= n-1;i++){
            int j = i;
            while(j > 0 && arr[j-1] > arr[j]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args){
        int[] EmployeeIDArray = {13, 47, 23, 5, 18, 2};
        System.out.print("ID's Before sort : ");
        for(int id: EmployeeIDArray){
            System.out.print(id + " ");
        }

        insertionSort(EmployeeIDArray);
        System.out.print("\nID'S After sort : ");
        for(int id: EmployeeIDArray){
            System.out.print(id + " ");
        }
    }
}

