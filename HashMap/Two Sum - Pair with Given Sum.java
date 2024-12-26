//https://www.geeksforgeeks.org/problems/key-pair5616/1

class Solution {
    boolean twoSum(int arr[], int target) {
        HashSet<Integer>set=new HashSet<>();
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=target-arr[i];
            if(set.contains(sum)){
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }
}