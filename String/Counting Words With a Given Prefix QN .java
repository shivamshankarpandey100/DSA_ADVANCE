//https://leetcode.com/problems/counting-words-with-a-given-prefix

class Solution {
    public int prefixCount(String[] words, String pref) {
        int k = pref.length();
        int cnt = 0;
        for (String s : words) {
            int c = 0;
            if (s.length() >= k) {

                for (int i = 0; i < k; i++) {
                    if (s.charAt(i) == pref.charAt(i)) {
                        c++;
                    }
                }
                if (c == k) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}