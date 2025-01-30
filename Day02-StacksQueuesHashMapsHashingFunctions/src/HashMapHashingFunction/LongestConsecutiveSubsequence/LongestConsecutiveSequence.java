package HashMapHashingFunction.LongestConsecutiveSubsequence;

import java.util.HashMap;

public class LongestConsecutiveSequence {

    public static int findLongestConsecutiveSequence(int[] arr){
        int longest = 0;
        if(arr.length == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: arr){
            if(map.containsKey(num)){
                continue;
            }

            int left = map.containsKey(num-1) ? map.get(num-1) : 0;
            int right = map.containsKey(num+1) ? map.get(num+1) : 0;

            int currentLength = left + right + 1;

            longest = Math.max(longest, currentLength);
            map.put(num, currentLength);
            map.put(num-left, currentLength);
            map.put(num+right, currentLength);
        }
        return longest;
    }

    public static void main(String[] args){

    }
}
