//https://www.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1

class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        int length = arr.length;
        if (length == 0 || arr == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        int currentSum = 0;
        while (right < length) {
            currentSum += arr[right];
            while (left < length && currentSum > target) {
                currentSum -= arr[left];
                left++;
            }
            if (currentSum == target) {
                result.add(left + 1);
                result.add(right + 1);
                return result;
            }
            right++;
        }
        result.add(-1);
        return result;
    }
}