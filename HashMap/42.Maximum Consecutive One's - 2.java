


class Solution {
    public static int longestOnes(int n, int[] nums, int k) {
        
        int len = 0;
        int i = 0;
        int j = -1;
        int zc = 0;

        while(i < nums.length && j < i){
            while(i < nums.length){
                if(nums[i] == 1){

                }else if(nums[i] == 0){
                    zc++;
                }

                if(zc <= k){
                    int tlen = i - j;
                    len = Math.max(len, tlen);
                    i++;
                }else{
                    i++;
                    break;
                }
            }

            while(j < i){
                j++;
                if(nums[j] == 0){
                    zc--;
                }

                if(zc <= k){
                    break;
                }
            }
        }

        return len;
    }
}