//  https://practice.geeksforgeeks.org/problems/sum-equals-to-sum4006/1


import java.util.*;
class Main48 {

    public static boolean solution(int[] arr) {
        
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                int sum = arr[i] + arr[j];
                if(set.contains(sum)){
                    return true;
                }else{
                    set.add(sum);
                }
            }
        }

        return false;
    }
}


// <---GFG--->
class Solution
{ 
    public int findPairs(int arr[],int n) 
    { 
        
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                int sum = arr[i] + arr[j];
                if(set.contains(sum)){
                    count = 1;
                    break;
                }else{
                    set.add(sum);
                }
            }
        }

        return count;
    }
}