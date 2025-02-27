//https://leetcode.com/problems/length-of-longest-fibonacci-subsequence

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        
        HashSet<Integer> set = new HashSet<>();
        for(int val : arr){
            set.add(val);
        }

        int max = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                int len = 2;
                int val1 = arr[j];
                int val2 = arr[i] + arr[j];

                while (set.contains(val2)) {
                    len++;
                    val2 += val1;
                    val1 = val2 - val1;
                }

                max = Math.max(len, max);
            }
        }

        return max > 2 ? max : 0;
    }
}