//https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        HashSet<Integer> seen = new HashSet<>();
        int commonCount = 0;

        for (int i = 0; i < n; i++) {
            if (seen.contains(A[i])) {
                commonCount++;
            } else {
                seen.add(A[i]);
            }
            
            if (seen.contains(B[i])) {
                commonCount++;
            } else {
                seen.add(B[i]);
            }
            
            C[i] = commonCount;
        }

        return C;
    }
}
