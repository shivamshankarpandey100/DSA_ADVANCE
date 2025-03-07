//https://leetcode.com/problems/closest-prime-numbers-in-range/



class Solution {
    public int[] closestPrimes(int left, int right) {

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = left; i <= right; i++){
            if(isPrime(i)){
                list.add(i);
            }
        }

        if(list.size() < 2){
            return new int[]{-1, -1};
        }

        int min = Integer.MAX_VALUE;
        int ans[] = new int[2];

        for(int i = 1; i < list.size(); i++){
            int diff = list.get(i) - list.get(i - 1);
            if(diff < min){
                min = diff;
                ans[0] = list.get(i - 1);
                ans[1] = list.get(i);
            }
        }

        return ans;
    }

    boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

}