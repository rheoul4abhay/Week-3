package BinarySearch.FindPeakElement;

public class PeakElement {

    public static int findPeakElement(int[] arr){
        int low = 0;
        int high = arr.length-1;

        while(low < high){
            int mid = low + (high-low)/2;
            if((arr[mid] > arr[mid+1]) && (arr[mid] > arr[mid-1])){
                return arr[mid];
            }
            else if(arr[mid] < arr[mid-1]){
                high = mid-1;
            }
            else if(arr[mid] < arr[mid+1]){
                low = mid+1;
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,3,5,6,4};
        int result = PeakElement.findPeakElement(arr);
        System.out.println(result == Integer.MAX_VALUE ? "\nPeak element not present!" : "\nPeak element in array : " + result);
    }
}
