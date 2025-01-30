package HashMapHashingFunction.AllSubarrayWithZeroSum;

import java.util.*;

public class SubarrayWithZeroSum{

    //Brute force approach
    public static List<int[]> findZeroSumSubarrays(int[] arr){
        List<int[]> result = new ArrayList<>();

        for(int i = 0; i < arr.length;i++){
            int sum = 0;
            for(int j = i;j < arr.length;j++){
                sum += arr[j];
                if(sum == 0){
                    result.add(new int[]{i,j});
                }
            }
        }
        return result;
    }

    //Better Approach
    public static List<int[]> findZeroSumSubarrays2(int[] arr){
        List<int[]> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;

        sumMap.put(0, new ArrayList<>(List.of(-1)));

        for(int i = 0;i < arr.length; i++){
            sum += arr[i];

            if(sumMap.containsKey(sum)){
                for(int start : sumMap.get(sum)){
                    result.add(new int[]{start + 1, i});
                }
            }

            //if the sum is not present, add it to the list
            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }
        return result;
    }

    public static void main(String[] args){
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        List<int[]> subarrays = findZeroSumSubarrays2(arr);

        for (int[] subarray : subarrays) {
            System.out.println("Subarray found from index " + subarray[0] + " to " + subarray[1]);
        }
    }
}