//https://leetcode.com/problems/construct-string-with-repeat-limit
import java.util.PriorityQueue;

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[]{i, freq[i]}); 
            }
        }

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int[] current = maxHeap.poll(); // Get the largest character
            char currChar = (char) (current[0] + 'a');
            int currFreq = current[1];

            int timesToUse = Math.min(currFreq, repeatLimit);
            for (int i = 0; i < timesToUse; i++) {
                result.append(currChar);
            }

           
            if (currFreq > timesToUse) {
                if (maxHeap.isEmpty()) break; 

                int[] next = maxHeap.poll(); // Get the next largest character
                char nextChar = (char) (next[0] + 'a');
                int nextFreq = next[1];

                result.append(nextChar);
                nextFreq--;

                if (nextFreq > 0) {
                    maxHeap.offer(new int[]{next[0], nextFreq});
                }
                maxHeap.offer(new int[]{current[0], currFreq - timesToUse});
            }
        }

        return result.toString();
    }
}
