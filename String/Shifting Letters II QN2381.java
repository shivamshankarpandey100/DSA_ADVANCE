//https://leetcode.com/problems/shifting-letters-ii/

class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shift = new int[n + 1]; 
        for (int[] shiftOp : shifts) {
            int start = shiftOp[0];
            int end = shiftOp[1];
            int direction = shiftOp[2];
            if (direction == 1) {
                shift[start] += 1;
                shift[end + 1] -= 1;
            } else {
                shift[start] -= 1;
                shift[end + 1] += 1;
            }
        }
        
       int cumulativeShift = 0;
        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            cumulativeShift += shift[i];
            int effectiveShift = (cumulativeShift % 26 + 26) % 26; 
            result[i] = (char) ('a' + (s.charAt(i) - 'a' + effectiveShift) % 26);
        }
        
        return new String(result);
    }
}
