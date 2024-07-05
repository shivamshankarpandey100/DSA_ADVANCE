

//    https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/queens-permutations-2das2d-box-chooses-official/ojquestion


import java.io.*;
class Main{

    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        if(row == tq){
            if(qpsf == tq){
                System.out.println(asf);
                System.out.println();
            }
            return;
        }

        if(col == tq - 1){
            for(int i = 0; i < queens.length; i++){
                if(queens[i] == false){
                    queens[i] = true;
                    queensPermutations(qpsf + 1, tq, row + 1, 0, asf + "q" + (i + 1) + "\n", queens);
                    queens[i] = false;
                }
            }

            queensPermutations(qpsf + 0, tq, row + 1, 0, asf + "-\n", queens);
        }else{
            for(int i = 0; i < queens.length; i++){
                if(queens[i] == false){
                    queens[i] = true;
                    queensPermutations(qpsf + 1, tq, row, col + 1, asf + "q" + (i + 1) + "\t", queens);
                    queens[i] = false;
                }
            }

            queensPermutations(qpsf + 0, tq, row, col + 1, asf + "-\t", queens);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, 0, "", queens);
    }
}