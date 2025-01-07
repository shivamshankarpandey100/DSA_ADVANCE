//https://leetcode.com/problems/string-matching-in-an-array

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < words.length; i++){
            String str = words[i];

            for(String s : words){
                if(s.contains(str) && !s.equals(str)){
                    set.add(str);
                }
            }
        }

        for(String str : set){
            list.add(str);
        }

        return list;        
    }
}