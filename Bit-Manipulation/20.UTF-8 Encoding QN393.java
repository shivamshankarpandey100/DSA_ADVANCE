

//  https://leetcode.com/problems/utf-8-validation/


class Main{

    public static boolean solution(int[] arr) {
        
        int remBytes = 0;

        for(int val : arr){
            if(remBytes == 0){
                if((val >> 7) == 0b0){
                    remBytes = 0;
                }else if((val >> 5) == 0b110){
                    remBytes = 1;
                }else if((val >> 4) == 0b1110){
                    remBytes = 2;
                }else if((val >> 3) == 0b11110){
                    remBytes = 3;
                }
                else{
                    return false;
                }
            }else{
                if((val >> 6) == 0b10){
                    remBytes--;
                }else if((val >> 6) != 0b10){
                    return false;
                }
            }
        }
    
        if(remBytes == 0){
            return true;
        }else{
            return false;
        }
        
    }
}