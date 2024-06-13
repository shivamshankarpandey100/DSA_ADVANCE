

// https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/

//  https://leetcode.com/problems/fruit-into-baskets/


import java.util.*;
class Main62 {

    public static int lengthOfLongestSubstringTwoDistinct(String str) {

        if(str.length() == 1){
            return 1;
        }
        int ans = 0;
        int i = -1;
        int j = -1;

        HashMap<Character, Integer> map = new HashMap<>();

        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            while (i < str.length() - 1) {
                f1 = true;
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if (map.size() < 2) {
                    continue;
                } else if (map.size() == 2) {
                    int len = i - j;
                    if (len > ans) {
                        ans = len;
                    }
                } else {
                    break;
                }
            }

            while (j < i) {
                f2 = true;
                j++;
                char ch = str.charAt(j);
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }

                if (map.size() > 2) {
                    continue;
                } else if (map.size() == 2) {
                    int len = i - j;
                    if (len > ans) {
                        ans = len;
                    }
                    break;
                }
            }

            if (f1 == false && f2 == false) {
                break;
            }
        }

        return ans;
    }
}


//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

class Solution {
    public int totalFruit(int[] fruits) {
      
        int ans = 0;
        int i = -1;
        int j = -1;

        HashMap<Integer, Integer> map = new HashMap<>();

        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            while (i < fruits.length - 1) {
                f1 = true;
                i++;
                int ch = fruits[i];
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if  (map.size() <= 2) {
                    int len = i - j;
                    if (len > ans) {
                        ans = len;
                    }
                } else {
                    break;
                }
            }

            while (j < i) {
                f2 = true;
                j++;
                int ch = fruits[j];
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }

                if (map.size() > 2) {
                    continue;
                } else if (map.size() == 2) {
                    int len = i - j;
                    if (len > ans) {
                        ans = len;
                    }
                    break;
                }
            }

            if (f1 == false && f2 == false) {
                break;
            }
        }

        return ans;
    }

}