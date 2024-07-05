


import java.io.*;
class Main {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j){
        
        if(qpsf == tq){
            for(int m = 0; m < chess.length; m++){
                for(int n = 0; n < chess.length; n++){
                    if(chess[m][n] == true){
                        System.out.print("q\t");
                    }else{
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }


        for(int m = i; m < chess.length; m++){
            for(int n = (m == i ? j + 1 : 0); n < chess.length; n++){
                if(chess[m][n] == false){
                    chess[m][n] = true;
                    queensCombinations(qpsf + 1, tq, chess, m, n);
                    chess[m][n] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
        
        queensCombinations(0, n, chess, 0, -1);
    }
}