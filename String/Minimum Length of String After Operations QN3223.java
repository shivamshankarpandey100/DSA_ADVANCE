//https://leetcode.com/problems/minimum-length-of-string-after-operations

class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int ans = s.length();
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            if (map.get(ch) > 2) {
                map.put(ch, 1);
                ans -= 2;
            }
        }
        
        return ans;
    }
}