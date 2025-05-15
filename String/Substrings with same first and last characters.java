//https://www.geeksforgeeks.org/problems/substrings-with-similar-first-and-last-characters3644/1

class Solution {
    public int countSubstring(String s) {
        // code here
        int[] freq = new int[26]; // since s contains only lowercase letters

        // Count frequencies of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int count = 0;

        // For each character, apply the formula: freq * (freq + 1) / 2
        for (int f : freq) {
            count += (f * (f + 1)) / 2;
        }

        return count;
    }
}

