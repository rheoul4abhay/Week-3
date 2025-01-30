package QuickSort.SortProductPrices;

public class SortProductPrices {

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low-1; //This will make room for the elements to be placed at correct places

        for(int j = low;j < high;j++){
            if(arr[j] < pivot){
                i++;

                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        //put pivot in its correct place
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i;
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex-1);
            quickSort(arr, pivotIndex+1, high);
        }
    }

    public static void main(String[] args){
        int[] prices = {13, 47, 23, 5, 18, 2};
        System.out.print("Before sort : ");
        for(int price: prices){
            System.out.print(price + " ");
        }
        int low = 0;
        int high = prices.length-1;
        quickSort(prices, low, high);
        System.out.print("\nAfter sort : ");
        for(int price: prices){
            System.out.print(price + " ");
        }
    }
}
