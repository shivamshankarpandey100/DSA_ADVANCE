//https://www.geeksforgeeks.org/problems/rotate-by-90-degree-1587115621/1

class Solution {
    static void rotateby90(int mat[][]) {
        int n=mat.length;
        
        for(int i=0;i<n;i++){
            int j=0;
            int k=n-1;
            while(j<k){
                int temp=mat[i][j];
                mat[i][j]=mat[i][k];
                mat[i][k]=temp;
                j++;
                k--;
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
    }
}

