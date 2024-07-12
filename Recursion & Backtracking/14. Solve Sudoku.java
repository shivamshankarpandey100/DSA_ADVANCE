import java.util.*;
class Main{
  public static void display(int[][] board){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void solveSudoku(int[][] board, int i, int j) {
    
    if(i == board.length){
        display(board);
        return;
    }

    int ni = 0;
    int nj = 0;

    if(j == board.length - 1){
        ni = i + 1;
        nj = 0;
    }else{
        ni = i;
        nj = j + 1;
    }

    if(board[i][j] != 0){
        solveSudoku(board, ni, nj);
    }else{
        for(int val = 1; val <= 9; val++){
            if(isSafe(board, i , j, val) == true){
                board[i][j] = val;
                solveSudoku(board, ni, nj);
                board[i][j] = 0;
            }
        }
    }
  }

  public static boolean isSafe(int [][]board, int i, int j, int val){
    for(int jj = 0; jj < board.length; jj++){
        if(board[i][jj] == val){
            return false;
        }
    }

    for(int ii = 0; ii < board.length; ii++){
        if(board[ii][j] == val){
            return false;
        }
    }

    int x = i / 3 * 3;
    int y = j / 3 * 3;

    for(int ii = 0; ii < 3; ii++){
        for(int jj = 0; jj < 3; jj++){
            if(board[x + ii][y + jj] == val){
                return false;
            }
        }
    }

    return true;
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    solveSudoku(arr, 0, 0);


    scn.close();
  }
}
