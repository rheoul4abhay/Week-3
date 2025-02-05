package BinarySearch.FindRotationPoint;

public class FindRotationPoint {

    public static int binarySearch(int[] arr){
        if(arr.length == 0) return -1;
        int left = 0;
        int right = arr.length-1;

        while(left < right){
            int mid = left + (right-left)/2;
            if(arr[mid] > arr[right]){
                //means the rotation point is in the right of mid, so we update left
                left = mid+1;
            }
            else if(arr[mid] < arr[right]){
                //means the smallest element is in the left half
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,1,2,3,4};
        //our aim is to return te index of the smallest number in the array
        int result = binarySearch(arr);
        System.out.print("\nRotation point(smallest number index) is : " + result);
    }
}
