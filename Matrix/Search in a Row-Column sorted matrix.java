//https://www.geeksforgeeks.org/problems/search-in-a-matrix17201720/1

class Solution {
    public static boolean matSearch(int mat[][], int x) {
           int n =mat.length-1; int m = mat[0].length;
        int i=0;int j=m-1;
        
        while(i<=n && j>=0){
            
            if(x>mat[i][j]){
                i++;
            }else if(x<mat[i][j]){
                j--;
            }else{
                return true;
            }
        }
        return false;
    }
}