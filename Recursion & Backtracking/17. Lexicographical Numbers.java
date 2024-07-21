import java.util.*;
class Main{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
                int n = scn.nextInt();

                //write your code here
                for(int i = 1; i <=9; i++){
                    lexico(i, n);
                }

        scn.close();
	}

    public static void lexico(int curr, int n){

                if(curr > n){
                    return;
                }

         System.out.println(curr);

            for(int i = 0; i <= 9; i++){
                lexico(curr * 10 + i, n);
            }
    }
	
}