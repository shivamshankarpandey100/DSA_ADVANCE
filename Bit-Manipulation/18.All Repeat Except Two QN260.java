


//  https://leetcode.com/problems/single-number-iii/

//  https://practice.geeksforgeeks.org/problems/two-repeated-elements-1587115621/1

//  https://practice.geeksforgeeks.org/problems/finding-the-numbers0215/1


import java.util.*;
class Main {
  public static void solution(int[] arr) {

    int xxory = 0;
    for (int val : arr) {
      xxory = xxory ^ val;
    }

    int rmsb = xxory & -xxory; // rmsb = right most set bit

    int x = 0;
    int y = 0;

    for (int val : arr) {
      if ((val & rmsb) == 0) {
        x = x ^ val;
      } else {
        y = y ^ val;
      }
    }

    if (x < y) {
      System.out.println(x);
      System.out.println(y);
    } else {
      System.out.println(y);
      System.out.println(x);
    }

  }

}

// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

class Solution {
  public int[] singleNumber(int[] nums) {

    HashMap<Integer, Integer> map = new HashMap<>();
    int[] ans = new int[2];

    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }

    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if (map.get(nums[i]) == 1) {
        ans[j] = nums[i];
        j++;
      }
    }

    Arrays.sort(ans);
    return ans;

  }
}