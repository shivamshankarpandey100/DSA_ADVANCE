


import java.util.*;
class Solution
{    
    public static boolean isAnagram(String a,String b)
    {
        if(a.length() != b.length()){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < a.length(); i++){
            char ch = a.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < b.length(); i++){
            char ch = b.charAt(i);

            if(map.containsKey(ch) == false){
                return false;
            }else if(map.get(ch) == 1){
                map.remove(ch);
            }else{
                map.put(ch, map.get(ch) - 1);
            }
        }

        return map.size() == 0;
    }
}