//https://leetcode.com/problems/group-anagrams/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}



//<--------------------------2nd Method------------------------>




//    https://leetcode.com/problems/group-anagrams/description/


import java.util.*;
class Main18 {

	public static ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
		
		HashMap<HashMap<Character, Integer>, ArrayList<String>> bmap = new HashMap<>();

		for(String str : strs){
			HashMap<Character, Integer> fmap = new HashMap<>();
			for(int i = 0; i < str.length(); i++){
				char ch = str.charAt(i);
				fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
			}

			if(bmap.containsKey(fmap) == false){
				ArrayList<String> list = new ArrayList<>();
				list.add(str);
				bmap.put(fmap, list);
			}else{
				ArrayList<String> list = bmap.get(fmap);
				list.add(str);
			}
		}
		
		ArrayList<ArrayList<String>> res = new ArrayList<>();
		for(ArrayList<String> val : bmap.values()){
			res.add(val);
		}

		return res;
	}

	// it is used to make the result unique
	static class ListComparator implements Comparator<List<String>> {
		@Override
		public int compare(List<String> l1, List<String> l2) {
			if (l1.size() != l2.size()) {
				return l2.size() - l1.size();
			}

			String l1str = l1.get(0);
			String l2str = l2.get(0);
			return l1str.compareTo(l2str);

		}
	}
}
//<<<<<<< --------------------------3rd Method------------------------>
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        		HashMap<HashMap<Character, Integer>, ArrayList<String>> bmap = new HashMap<>();

		for(String str : strs){
			HashMap<Character, Integer> fmap = new HashMap<>();
			for(int i = 0; i < str.length(); i++){
				char ch = str.charAt(i);
				fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
			}

			if(bmap.containsKey(fmap) == false){
				ArrayList<String> list = new ArrayList<>();
				list.add(str);
				bmap.put(fmap, list);
			}else{
				ArrayList<String> list = bmap.get(fmap);
				list.add(str);
			}
		}
		
		List<List<String>> res = new ArrayList<>();
		for(ArrayList<String> val : bmap.values()){
			res.add(val);
		}

		return res;
    }
}