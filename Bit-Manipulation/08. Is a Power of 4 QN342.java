

//  https://leetcode.com/problems/power-of-four/description/

//  https://practice.geeksforgeeks.org/problems/power-of-four/1


class Solution {

    public static boolean ispower2(int n) {
        return n > 0 && (n & (n - 1)) == 0;

    }

    public boolean isPowerOfFour(int n) {
        if (!ispower2(n))
            return false;

        int count = 0;// count of zeros before 1
        while (n != 1) {// count of zeros before 1
            count++;
            n >>>= 1;// right shift by 1 bit and fill with 0
        }

        return (count & 1) == 0;// if count is even then return true
    }
}

// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

class Solution {
    public static long ispower2(long n) {
        if (n < 0) {// if n is negative then it can't be power of 2
            return 0;
        }

        if ((n & (n - 1)) == 0) {// if n is power of 2 then n & (n-1) will be 0 because n-1 will have all 1's
            return 1;
        }

        return 0;
    }

    int isPowerOfFour(long n) {// long is used because n can be upto 10^18
        if (ispower2(n) == 1) {

            int count = 0;
            while (n != 1) {
                count++;
                n >>>= 1;
            }

            if ((count & 1) == 0) {// if count is even then return true
                return 1;
            }
        }

        return 0;
    }
}