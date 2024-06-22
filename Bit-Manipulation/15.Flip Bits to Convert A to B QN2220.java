

//  https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/

//  https://practice.geeksforgeeks.org/problems/bit-difference-1587115620/1


import java.util.*;
class Main{

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();

    //write your code here

    int xor = a ^ b;
    int count = 0;

    while(xor != 0){
        xor = xor & (xor - 1);
        count++;
    }

    System.out.println(count);


    scn.close();
  }

}