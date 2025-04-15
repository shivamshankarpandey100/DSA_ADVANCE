//https://leetcode.com/problems/count-good-triplets-in-an-array/https://leetcode.com/problems/count-good-triplets-in-an-array/

class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pos2 = new int[n];
        for (int i = 0; i < n; i++) {
            pos2[nums2[i]] = i;
        }

        int[] indexInNums2 = new int[n];
        for (int i = 0; i < n; i++) {
            indexInNums2[i] = pos2[nums1[i]];
        }

        // Count of elements before i with indexInNums2[j] < indexInNums2[i]
        long[] leftCount = new long[n];
        FenwickTree leftTree = new FenwickTree(n);
        for (int i = 0; i < n; i++) {
            leftCount[i] = leftTree.query(indexInNums2[i]);
            leftTree.update(indexInNums2[i], 1);
        }

        // Count of elements after i with indexInNums2[j] > indexInNums2[i]
        long[] rightCount = new long[n];
        FenwickTree rightTree = new FenwickTree(n);
        for (int i = n - 1; i >= 0; i--) {
            rightCount[i] = rightTree.query(n - 1) - rightTree.query(indexInNums2[i]);
            rightTree.update(indexInNums2[i], 1);
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            res += leftCount[i] * rightCount[i];
        }

        return res;
    }

    class FenwickTree {
        long[] tree;

        public FenwickTree(int size) {
            tree = new long[size + 1];
        }

        public void update(int index, long value) {
            index++;  // BIT is 1-indexed
            while (index < tree.length) {
                tree[index] += value;
                index += index & -index;
            }
        }

        public long query(int index) {
            index++;  // BIT is 1-indexed
            long sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }
            return sum;
        }
    }
}
