//https://www.geeksforgeeks.org/problems/smallest-positive-missing-number-1587115621/1

class Solution {
    public int missingNumber(int[] arr) {
        HashSet<Integer> map = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE; int res=0;
        for(int ar:arr){
            min = Math.min(ar,min);
            max = Math.max(ar,max);
            map.add(ar);
        }
        for(int i = 1;i<max;i++){
            if(!map.contains(i) && i>0){
                
                return i;
            }
        }
        if(min>1){
            res = 1;
        }else{
            if(max >= 0){
            res = max+1;
            }else{
                res = 1;
            }
        }
        return res;
    }
}