//https://www.geeksforgeeks.org/problems/maximum-value-in-a-bitonic-array3001/1

class Solution {
    public int findMaximum(int[] arr) {
        // code here
        int max = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > arr[i - 1]){
                max = arr[i];
            }
        }
        return max;
    }
}