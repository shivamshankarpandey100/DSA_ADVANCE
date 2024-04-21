

//   https://leetcode.com/problems/find-all-anagrams-in-a-string/description/


import java.util.*;
class Main14{
	public static void findAnagrams(String s, String p) {
        
        int [] map2 = new int[26];
        for(int i = 0; i < p.length(); i++){
            char ch = p.charAt(i);
            map2[ch - 'a']++;
        }

        int [] map1 = new int[26];
        for(int i = 0; i < p.length(); i++){
            char ch = s.charAt(i);
            map1[ch - 'a']++;
        }

        ArrayList<Integer> res = new ArrayList<>();
        if(areAnagram(map1, map2) == true){
            res.add(0);
        }  

        int i = p.length();
        int j = 0;

        while (i < s.length()){
            char chi = s.charAt(i);
            map1[chi - 'a']++;

            char chj = s.charAt(j);
            if(map1[chj - 'a'] > 0){
                map1[chj - 'a']--;
            }

            if(areAnagram(map1, map2) == true){
                res.add(j + 1);
            }

            i++;
            j++;
        }

        System.out.println(res.size());
        for(int val : res){
            System.out.println(val + " ");
        }
        
	}

    public static boolean areAnagram(int [] map1, int [] map2){
        for(int i = 0; i < 26; i++){
            if(map1[i] != map2[i]){
                return false;
            }
        }
        return true;
    }
}