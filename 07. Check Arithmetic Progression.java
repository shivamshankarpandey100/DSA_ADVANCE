//https://www.geeksforgeeks.org/problems/check-arithmetic-progression1842/1
class Solution
{
    boolean checkIsAP(int arr[] ,int n)
    {
        // code here
        HashSet<Integer> set =new HashSet<>();
        
        int min= Integer.MAX_VALUE;
        int smin= Integer.MAX_VALUE;
        
        for(int val:arr){
            set.add(val);
            
            if(val<min){
                smin=min;
                min=val;
            }else if(val<smin){
                smin=val;
            }
        }
        
        int d=smin-min;
        for(int i=1;i<=n;i++){
            int term=min+(i-1)*d;
            
            if(!set.contains(term)){
                return false;
            }
        }
        return true;
    }
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX      2nd Method     XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


class Solution2 {
    public boolean canMakeArithmeticProgression(int[] arr) {

        if(arr.length == 2){
            return true;
        }

        Arrays.sort(arr);
        int diff = arr[1] - arr[0];

        for(int i = 2; i < arr.length; i++){
            int currdiff = arr[i] - arr[i - 1];
            if(currdiff != diff){
                return false;
            }
        }

        return true;
    }
}