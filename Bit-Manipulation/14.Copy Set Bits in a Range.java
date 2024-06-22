

//  https://practice.geeksforgeeks.org/problems/copy-set-bits-in-range0623/1


import java.util.Scanner;
class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();
    int left = scn.nextInt();
    int right = scn.nextInt();

   //write your code here

   int m1 = 1;
   int m2 = m1 << (right - left + 1);
   int m3 = m2 - 1;
   int m4 = m3 << (left - 1);

   int m5 = m4 & a;

   int ans = m5 | b;
   System.out.println(ans);


   scn.close();
    
  }

}