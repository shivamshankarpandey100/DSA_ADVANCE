

//   https://leetcode.com/problems/palindrome-pairs/description/

//   https://practice.geeksforgeeks.org/problems/palindrome-pairs/1

//   https://www.codingninjas.com/studio/problems/count-palindromic-pairs_3210217


import java.util.*;
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();

        if(words == null || words.length < 2){
            return ans;
        }

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            map.put(new StringBuilder(words[i]).reverse().toString(), i);
        }

        for(int i = 0; i < words.length; i++){
            for(int j = 0; j <= words[i].length(); j++){

                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);

                if(isPalindrom(str1)){
                    if(map.containsKey(str2) && map.get(str2) != i){
                        ans.add(Arrays.asList(map.get(str2), i));
                    }
                }

                if(isPalindrom(str2)){
                    if(map.containsKey(str1) && map.get(str1) != i && str2.length() != 0){
                        ans.add(Arrays.asList(i, map.get(str1)));
                    }
                }
            }
        }

        return ans;
    }



    boolean isPalindrom(String s){
        int l = 0;
        int r = s.length() - 1;

        while(l <= r){
            if(s.charAt(l++) != s.charAt(r--)){
                return false;
            }
        }

        return true;
    }
}


//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX======>     GFG      <=======XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

 
class Solution2 {
    static boolean palindromepair(int N, String words[]) {
     
        if(words == null || words.length < 2){
            return false;
        }

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            map.put(new StringBuilder(words[i]).reverse().toString(), i);
        }

        for(int i = 0; i < words.length; i++){
            for(int j = 0; j <= words[i].length(); j++){

                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);

                if(isPalindrom(str1)){
                    if(map.containsKey(str2) && map.get(str2) != i){
                         return true; 
                    }
                   
                }

                if(isPalindrom(str2)){
                    if(map.containsKey(str1) && map.get(str1) != i && str2.length() != 0){
                         return true;
                    }
                   
                }
            }
        }

        return false;
    }



    static boolean isPalindrom(String s){
        int l = 0;
        int r = s.length() - 1;

        while(l <= r){
            if(s.charAt(l++) != s.charAt(r--)){
                return false;
            }
        }

        return true;
    }
}