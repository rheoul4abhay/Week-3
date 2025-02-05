package BinarySearch.FirstAndLastOccurence;

public class FirstLastOccurence {

    public static int binarySearch(int[] arr, int target){
        int low = 0;
        int high = arr.length-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }

    public static int searchFirstOccurence(int arr[], int firstOccurence, int target){
        if(firstOccurence == 0) return 0;

        int low = 0;
        int high = firstOccurence-1;
        int leftMost = firstOccurence;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                leftMost = Math.min(firstOccurence, mid);
                high = mid-1;
            } else if(arr[mid] < target){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return leftMost;
    }

    public static int searchLastOccurence(int arr[], int firstOccurence, int target){
        if(firstOccurence == arr.length-1) return arr.length-1;

        int low = firstOccurence + 1;
        int high = arr.length-1;
        int rightMost = firstOccurence;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                rightMost = Math.max(rightMost, mid);
                low = mid+1;
            } else if(arr[mid] < target){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return rightMost;
    }

    public static int[] findFirstLastOccurence(int[] arr, int target){
        int firstOccurence = binarySearch(arr, target);
        if(firstOccurence == -1) return new int[]{-1,-1};
        int leftMost = searchFirstOccurence(arr, firstOccurence, target);
        int rightMost = searchLastOccurence(arr, firstOccurence, target);

        return new int[]{leftMost, rightMost};
    }

    public static void main(String[] args) {
        int[] array = {1,2,2,2,4,4,4,4,5,6,7};
        int target = 2;
        int[] results = findFirstLastOccurence(array, target);
        System.out.print("\nFirst occurence index: " + results[0]);
        System.out.print("\nLast occurence index: " + results[1]);
    }
}
