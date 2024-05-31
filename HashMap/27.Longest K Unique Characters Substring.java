

//  https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1


import java.util.*;
class Main {

	public static int longestkSubstr(String str, int k){
		
		int ans = 0;
		int i = -1;
		int j = -1;

		HashMap<Character, Integer> map = new HashMap<>();

		while(true){
			boolean f1 = false;
			boolean f2 = false;

			while(i < str.length() - 1){
				f1 = true;
				i++;
				char ch = str.charAt(i);
				map.put(ch, map.getOrDefault(ch, 0) + 1);

				if(map.size() < k){
					continue;
				}else if(map.size() == k){
					int len = i - j;
					if(len > ans){
						ans = len;
					}
				}else{
					break;
				}
			}

			while(j < i){
				f2 = true;
				j++;
				char ch = str.charAt(j);
				if(map.get(ch) == 1){
					map.remove(ch);
				}else{
					map.put(ch, map.get(ch) - 1);
				}

				if(map.size() > k){
					continue;
				}else if(map.size() == k){
					int len = i - j;
					if(len > ans){
						ans = len;
					}
					break;
				}
			}

			if(f1 == false && f2 == false){
				break;
			}
		}
		

		return ans;
	}
}



// <-------------------------------2nd type------------------------------------>


class Solution {
    public int longestkSubstr(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return -1;
        }
        
        Map<Character, Integer> charCountMap = new HashMap<>();
        int left = 0, right = 0, maxLength = -1;
        
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            charCountMap.put(rightChar, charCountMap.getOrDefault(rightChar, 0) + 1);
            
            while (charCountMap.size() > k) {
                char leftChar = s.charAt(left);
                charCountMap.put(leftChar, charCountMap.get(leftChar) - 1);
                if (charCountMap.get(leftChar) == 0) {
                    charCountMap.remove(leftChar);
                }
                left++;
            }
            
            if (charCountMap.size() == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            
            right++;
        }
        
        return maxLength;
    }
}