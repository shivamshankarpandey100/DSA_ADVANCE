//  https://leetcode.com/problems/power-of-two/description/

//  https://practice.geeksforgeeks.org/problems/power-of-2-1587115620/1


class Main71 {

  public static boolean ispower2(int n) {
    return n > 0 && (n & (n - 1)) == 0;// if n is power of 2 then n & (n-1) will be 0 because n-1 will have all 1's

  }

}