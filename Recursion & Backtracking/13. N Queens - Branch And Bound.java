
import java.util.*;
class Main{

    public static void nqueensBnB(boolean [][] board, boolean [] cols, boolean [] ndiag, boolean[] rdiag, int qpsf, int tq, String asf){

        if(qpsf == tq){
            System.out.println(asf + ".");
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if(cols[i] == false && ndiag[qpsf + i] == false && rdiag[qpsf - i + board.length - 1] == false){
                board[qpsf][i] = true;
                cols[i] = true;
                ndiag[qpsf + i]= true;
                rdiag[qpsf - i + board.length - 1] = true;

                nqueensBnB(board, cols, ndiag, rdiag, qpsf + 1, tq, asf + qpsf + "-" + i + ",");

                board[qpsf][i] = false;
                cols[i] = false;
                ndiag[qpsf + i] = false;
                rdiag[qpsf - i + board.length - 1] = false;
            }
        }
    }
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    //write your code here

    boolean [] cols = new boolean[board.length];
    boolean [] ndiag = new boolean[2 * board.length - 1];
    boolean [] rdiag = new boolean[2 * board.length - 1];

    nqueensBnB(board, cols, ndiag, rdiag, 0, board.length, "");

    scn.close();
    
  }

}