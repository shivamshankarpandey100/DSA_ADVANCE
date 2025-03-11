//https://www.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair-1587115620/1

class Solution {
    int countWays(int n) {
        if(n==1)
        {
            return 1;
        }
        if(n==2)
        {
            return 2;
        }
        int a = 1;
        int b = 2;
        int result = 0;
        for(int i=3;i<=n;i++)
        {
            result = a+b;
            a = b;
            b = result;
        }
        return result;
        
    }
}

