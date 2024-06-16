//  https://leetcode.com/problems/number-of-1-bits/description/

//  https://practice.geeksforgeeks.org/problems/set-bits0143/1


import java.util.*;

class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    //write your code here

    int count=0;
    while(n!=0){
        int rmsb=n&-n;//-n is use for 2's complement
        n=n-rmsb;
        count++;
    }
    System.out.println(count);
    scn.close();
  }

}