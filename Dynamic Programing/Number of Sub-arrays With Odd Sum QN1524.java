//https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum

class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;
        int oddCount = 0, evenCount = 1; // evenCount = 1 since prefix sum 0 is even
        int prefixSum = 0, result = 0;
        
        for (int num : arr) {
            prefixSum += num;
            
            if (prefixSum % 2 == 0) {
                result = (result + oddCount) % MOD;
                evenCount++;
            } else {
                result = (result + evenCount) % MOD;
                oddCount++;
            }
        }
        
        return result;
    }
}
