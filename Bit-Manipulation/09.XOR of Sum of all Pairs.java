
class Main{

    public static int solution(int[] arr){
      
        int xor = 0;
        for(int ele : arr){
            xor = xor ^ ele;
        }
       
       return 2 * xor;// return (2<<1);
    }    
}

//////////////////////////////////////////////////////////////////////////
// class Solution{

// 	public int minSteps(int n) 
// 	{ 
// 	    // Your code goes here
// 	   int step = 0;
//         while(n != 1){
//            if(n != 0 && ((n & (n - 1)) == 0)){
//                n/=2;
//            }
//            else if((n ^ (n-1)) == 1 ){
//                n/=3;
//            }
//            else if(n != 0 && ((n & (n - 1)) == 0) && (n ^ (n-1))== 1){
//                n--;
//            }

//            step ++;
//         }
//         return step;
// }
// }