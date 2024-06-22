

//  https://practice.geeksforgeeks.org/problems/find-element-occuring-once-when-all-other-are-present-thrice/1

//  https://leetcode.com/problems/single-number-ii/description/


import java.util.*;
class Main76 {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n; i++){
      arr[i] = scn.nextInt();
    }
    solution(arr);

    scn.close();
  }

  public static void solution(int[] arr){
   
    int tn = -1;      // tn = 3 * n
    int tn1 = 0;      // tn1 = 3 * n + 1
    int tn2 = 0;      // tn2 = 3 * n + 2

    for(int val : arr){
        int csbwtn = tn & val;         // csbwtn = common set bit b/t tn
        int csbwtn1 = tn1 & val;
        int csbwtn2 = tn2 & val;

        tn = tn & ~csbwtn;
        tn1 = tn1 | csbwtn;

        tn1 = tn1 & ~csbwtn1;
        tn2 = tn2 | csbwtn1;

        tn2 = tn2 & ~csbwtn2;
        tn = tn | csbwtn2;
    }

    System.out.println(tn1);
   
  }

}