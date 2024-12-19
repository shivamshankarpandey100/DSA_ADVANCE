//https://www.geeksforgeeks.org/problems/kth-missing-positive-number-in-a-sorted-array/1

class Solution {
    public int kthMissing(int[] arr, int k) {
        int missingCount = 0;
        int current = 1; // Start checking from 1
        int index = 0;

        while (true) {
            // Check if the current number is missing
            if (index < arr.length && arr[index] == current) {
                // Number is in the array; move to the next array element
                index++;
            } else {
                // Number is missing
                missingCount++;
                if (missingCount == k) {
                    return current; // Found the k-th missing number
                }
            }
            current++; // Move to the next number
        }
    }
}
