//https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/
class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int res = -1;

        for (int num : nums) {
            int key = digitSum(num);
            if (freq.containsKey(key)) {
                res = Math.max(res, freq.get(key) + num);
                freq.put(key, Math.max(freq.get(key), num));
            } else {
                freq.put(key, num);
            }
        }

        return res;
    }

    public int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}