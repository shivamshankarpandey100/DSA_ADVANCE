//https://www.geeksforgeeks.org/problems/search-in-an-almost-sorted-array/1

class Solution {
    public int findTarget(int arr[], int target) {
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
        
    }
}