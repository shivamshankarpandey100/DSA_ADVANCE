 


//  https://practice.geeksforgeeks.org/problems/swap-all-odd-and-even-bits-1587115621/1


import java.util.*;
class Main{

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    //write your code here

    int evenMask = 0x5555555;
    int oddmask = 0xAAAAAAAA;

    int v1 = n & evenMask;
    int v2 = n & oddmask;

    v1 = v1 << 1;
    v2 = v2 >> 1;

    int ans = v1 | v2;
    System.out.println(ans);//return 
    

    scn.close();
  }

}