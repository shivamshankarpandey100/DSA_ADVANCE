class Solution{
    
  // if the given value in binary form 
    public static int maxConsecutiveOnes(int N) {
        
        int tl=0;
        
        int ml=0;
        
        
        // Your code here
        for(int i=0; i<arr.length;i++){
            if(arr[i]==1){
                tl=tl+1;
            }else{
                if(tl>ml){
                    ml=tl;
                }
                tl=0;
            }
        }
        return ml;
    }
}
