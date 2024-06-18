

//  https://leetcode.com/problems/power-of-four/description/

//  https://practice.geeksforgeeks.org/problems/power-of-four/1


class Solution {

    public static boolean ispower2(int n) {
        return n > 0 && (n & (n - 1)) == 0;

    }

    public boolean isPowerOfFour(int n) {
        if (!ispower2(n))
            return false;

        int count = 0;
        while (n != 1) {
            count++;
            n >>>= 1;
        }

        return (count & 1) == 0;
    }
}

// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

class Solution {
    public static long ispower2(long n) {
        if (n < 0) {
            return 0;
        }

        if ((n & (n - 1)) == 0) {
            return 1;
        }

        return 0;
    }

    int isPowerOfFour(long n) {
        if (ispower2(n) == 1) {

            int count = 0;
            while (n != 1) {
                count++;
                n >>>= 1;
            }

            if ((count & 1) == 0) {
                return 1;
            }
        }

        return 0;
    }
}