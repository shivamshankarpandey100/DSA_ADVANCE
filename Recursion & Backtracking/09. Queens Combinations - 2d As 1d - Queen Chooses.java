
import java.io.*;
class Main{

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {

        if (qpsf == tq) {
            for (int r = 0; r < chess.length; r++) {
                for (int c = 0; c < chess.length; c++) {
                    if (chess[r][c]) {
                        System.out.print("q\t");
                    } else {
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (chess[row][col] == false) {
                chess[row][col] = true;
                queensCombinations(qpsf + 1, tq, chess, i);
                chess[row][col] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, -1);
    }
}