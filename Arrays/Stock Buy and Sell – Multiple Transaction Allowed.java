//https://www.geeksforgeeks.org/problems/stock-buy-and-sell2615/1
class Solution {
    public int maximumProfit(int prices[]) {
        int profit=0;
        int n=prices.length;
        for(int i=1;i<n;i++){
            if(prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];
            }
        }
        return profit;
    }
}