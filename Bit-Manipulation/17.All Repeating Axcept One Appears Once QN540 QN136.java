

//  https://practice.geeksforgeeks.org/problems/element-appearing-once2552/1

//  https://practice.geeksforgeeks.org/problems/find-the-element-that-appears-once-in-sorted-array0624/1
 
//  https://practice.geeksforgeeks.org/problems/single-number1014/1

//  https://leetcode.com/problems/single-element-in-a-sorted-array/description/

//  https://leetcode.com/problems/single-number/


import java.util.*;

class Main{

  public static void  main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n; i++){
      arr[i] = scn.nextInt();
    }
    //write your code here

    int uniq = 0;
    for(int val : arr){
        uniq = uniq ^ val;
    }

    System.out.println(uniq);

    scn.close();
    
  }

}