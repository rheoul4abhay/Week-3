package HashMapHashingFunction.PairWithGivenSum;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CheckPairWithGivenSum {

    //Brute force approach(O(N^2))
    public static boolean checkPair(int[] arr, int k){
        int n = arr.length;
        for(int i = 0;i < n;i++){
            for(int j = i;j < n;j++){
                if(arr[i] + arr[j] == k){
                    return true;
                }
            }
        }
        return false;
    }

    //Optimal approach NlogN
    public static boolean checkPair2(int[] arr, int target){
        Arrays.sort(arr);
        int left = 0, right = arr.length-1;

        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum == target){
                return true;
            } else if(sum < target){
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static boolean checkPair3(int[] arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: arr){
            int complement = target - num;
            if((map.containsKey(complement))){
                return true;
            }

            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return false;
    }

    //Optimal approach using hash set
    public static boolean checkPair4(int[] arr, int target){
        int n = arr.length;
        HashSet<Integer> visited = new HashSet<>();
        for(int num: arr){
            if(visited.contains(target- num)){
                return true;
            }
            visited.add(num);
        }
        return false;
    }

    public static void main(String[] args){
        int[] arr = {3, 5, 2, 8, 11};
        int target = 14;
        //System.out.println(checkPair(arr, target));
        //System.out.println(checkPair2(arr, target));
        System.out.println(checkPair3(arr, target));
        //System.out.println(checkPair4(arr, target));

    }
}
