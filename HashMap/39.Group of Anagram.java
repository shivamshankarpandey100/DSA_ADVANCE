// https://leetcode.com/problems/group-anagrams/submissions/1278553912/
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            
            String sortedStr = new String(charArray);
            
            if (!anagramMap.containsKey(sortedStr)) {
                anagramMap.put(sortedStr, new ArrayList<>());
            }
            
            anagramMap.get(sortedStr).add(str);
        }
        
        return new ArrayList<>(anagramMap.values());
    }
}
