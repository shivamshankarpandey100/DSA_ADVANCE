

// https://leetcode.com/problems/find-the-winner-of-the-circular-game/description/

//  https://practice.geeksforgeeks.org/problems/josephus-problem/1


import java.util.*;
class Main{

    public static int powerof2(int n) {
        int i = 1;
        while (i * 2 <= n) {
            i = i * 2;
        }
        return i;
    }

    public static int solution(int n) {

        int hp2 = powerof2(n);
        int l = n - hp2;

        return 2 * l + 1;
    }
}

//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<2nd method>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

class Solution {
    public int josephus(int n, int k) {
        Queue<Integer> arr = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }

        while (arr.size() != 1) {
            for (int i = k - 1; i > 0; i--) {
                arr.add(arr.poll());
            }
            arr.poll();
        }
        return arr.poll();
    }

}