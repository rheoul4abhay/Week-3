package HashMapHashingFunction.TwoSumProblem;

import java.util.*;

public class TwoSum {

    //Brute force approach
    public static int[] twoSumBruteForce(int[] nums, int target){
        for(int i = 0;i < nums.length;i++){
            for(int j = i; j < nums.length;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    //Better approach

    public static int findIndex(int[] nums, int target){
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }

    // Overloaded findIndex method to avoid duplicate index finding
    public  static int findIndex(int[] nums, int target, int excludeIndex) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && i != excludeIndex) {
                return i;
            }
        }
        return -1;
    }

    public static int[] twoSumBetterApproach(int[] nums, int target){
        int[] numsCopy = nums.clone();
        Arrays.sort(numsCopy);
        int left = 0, right = numsCopy.length - 1;

        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                int index1 = findIndex(nums, numsCopy[left]);
                int index2 = findIndex(nums, numsCopy[right], index1);
                return new int[]{index1, index2};
            } else if(sum < target){
                left++;
            }
            else{
                right--;
            }
        }

        return new int[]{};
    }

    //Optimal approach
    public static int[] twoSumOptimalApproach(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0;i < nums.length;i++){
            int complement = target - nums[i];

            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 9;
        //int[] result = twoSumBruteForce(nums, target);
        //int[] result = twoSumBetterApproach(nums, target);
        int[] result = twoSumBetterApproach(nums, target);
        if(result.length > 0){
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No solution found!");
        }
    }
}
