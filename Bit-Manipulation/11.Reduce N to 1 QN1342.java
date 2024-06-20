

//  https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/

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
  
 int step = 0;
        while(n != 1){
           if((n % 2) == 0) n /= 2;       // 4x + 0
           else if(n == 3) n--;          
           else if((n % 4) == 1) n--;     // 4x + 1
           else if((n % 4) == 3) n++;     // 4x + 3

           step ++;
        }
        return step;