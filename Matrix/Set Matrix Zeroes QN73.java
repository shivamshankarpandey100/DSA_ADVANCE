//https://leetcode.com/problems/set-matrix-zeroes/

class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        boolean[] rowflag = new boolean[row];
        boolean[] colflag = new boolean[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j] == 0){
                    rowflag[i] = true;
                    colflag[j] = true;
                }
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(rowflag[i] == true || colflag[j] == true){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}