

//  https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/
// class Solution {
//     public int numberOfSteps(int num) {
//         int step=0;
//         while(num != 0){
//             if(num%2==0){
//                 num/=2;
//             }
//             else{
//                 num--;
//             }
//             step++;
//         }
//         return step;
//     }
// }


//  https://practice.geeksforgeeks.org/problems/minimum-steps-to-minimize-n-as-per-given-condition0618/1


class Main {

    public static int solution(long n) {
        
        int step = 0;
        while(n != 1){
           if((n & 1) == 0) n /= 2;       // 4x + 0
           else if(n == 3) n--;          
           else if((n & 3) == 1) n--;     // 4x + 1
           else if((n & 3) == 3) n++;     // 4x + 3

           step ++;
        }
        return step;
    }

}


// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
  
//  int step = 0;
//         while(n != 1){
//            if((n % 2) == 0) n /= 2;       // 4x + 0
//            else if(n == 3) n--;          
//            else if((n % 4) == 1) n--;     // 4x + 1
//            else if((n % 4) == 3) n++;     // 4x + 3

//            step ++;
//         }
//         return step;


        ///////////////////////////////////////////////////////////////////////
//         class Solution{

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