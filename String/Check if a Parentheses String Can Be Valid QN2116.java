//https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/

class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) return false; 
        int openMax = 0, openMin = 0;
        
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') {
                    openMax++;
                    openMin++;
                } else {
                    openMax--;
                    openMin--;
                }
            } else {
                openMax++; 
                openMin--; 
            }
            
            if (openMax < 0) return false; 
            openMin = Math.max(openMin, 0); 
        }
        
        if (openMin > 0) return false;
        
        openMax = 0;
        openMin = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == ')') {
                    openMax++;
                    openMin++;
                } else {
                    openMax--;
                    openMin--;
                }
            } else {
                openMax++; 
                openMin--;
            }
            
            if (openMax < 0) return false; 
            openMin = Math.max(openMin, 0); 
        }
        
        return openMin == 0;
    }
}
