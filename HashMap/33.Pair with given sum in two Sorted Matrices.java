


import java.util.*;
class Main {
	
    public static int solve(int[][] num1, int[][] num2, int k) {
		
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < num1.length; i++){
            for(int j = 0; j < num1[0].length; j++){
                map.put(num1[i][j], map.getOrDefault(num1[i][j], 0) + 1);
            }
        }

        int count = 0;

        for(int i = 0; i < num2.length; i++){
            for(int j = 0; j < num2[0].length; j++){
                int val = num2[i][j];
                if(map.containsKey(k - val)){
                    count += map.get(k - val);
                }
            }
        }

		return count;
	}
}


//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Solution 2 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


class Solution {
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        
        int size = mat1.length * mat2.length ;
        int left = 0;
        int right = mat2.length * mat2[0].length -1;
        int ans=0;
        while(left <size && right >=0){
            int r1= left/mat1[0].length;
            int c1= left%mat1[0].length;
            
            int r2= right/mat2[0].length;
            int c2= right%mat2[0].length;
            
            if(mat1[r1][c1] + mat2[r2][c2] == x){
                ++ans;
                left++;
                right--;
            }else if(mat1[r1][c1] + mat2[r2][c2] < x){
                left++;
            }else{
                right--;
            }
            
        }
        
        return ans;
    }
}