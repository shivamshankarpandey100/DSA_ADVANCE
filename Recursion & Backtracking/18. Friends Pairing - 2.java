import java.util.*;
class Main{
  static int counter = 1;

    public static void solution(int i, int n, boolean[] used, String asf) {
    // write your code here

        if(i == n + 1){
            System.out.println(counter + "." + asf);
            counter++;
             return;
        }

    if(used[i] == true){
        solution(i + 1, n, used, asf);
        }else{
            used[i] = true;
            solution(i + 1, n, used, asf + "(" + i + ") ");
            used[i] = false;
        }

    for(int j = i + 1; j <= n; j++){
            if(used[j] == false){
                 used[i] = true;
                 used[j] = true;
                 solution(i + 1, n, used, asf + "(" + i + "," + j + ") ");
                 used[i] = false;
                  used[j] = false;
            }
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] used = new boolean[n + 1];
        solution(1, n, used, "");


    sc.close();
  }
}
