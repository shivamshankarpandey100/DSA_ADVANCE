//https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/description/?envType=daily-question&envId=2024-11-20

class Solution {
    public int takeCharacters(String s, int k) {
        int[] totalCount = new int[3];
        for (char ch : s.toCharArray()) {
            totalCount[ch - 'a']++;
        }
        
        if (totalCount[0] < k || totalCount[1] < k || totalCount[2] < k) {
            return -1;
        }
        
        int n = s.length();
        int[] count = new int[3];
        int maxWindowSize = 0;
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            count[s.charAt(right) - 'a']++;
            
            while (count[0] > totalCount[0] - k || 
                   count[1] > totalCount[1] - k || 
                   count[2] > totalCount[2] - k) {
                count[s.charAt(left) - 'a']--;
                left++;
            }
            
            maxWindowSize = Math.max(maxWindowSize, right - left + 1);
        }
        
        return n - maxWindowSize;
    }
}
