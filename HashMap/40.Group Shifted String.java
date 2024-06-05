

import java.util.*;
class Main{

	public static ArrayList<ArrayList<String>> groupShiftedStrings(String[] strs) {
		
		HashMap<String, ArrayList<String>> map = new HashMap<>();

		for(String str : strs){
			String code = getCode(str);
			if(map.containsKey(code)){
				ArrayList<String> list = map.get(code);
				list.add(str);
				map.put(code, list);
			}else{
				ArrayList<String> list = new ArrayList<>();
				list.add(str);
				map.put(code, list);
			}
		}

		ArrayList<ArrayList<String>> res = new ArrayList<>();
		for(String code : map.keySet()){
			ArrayList<String> list = map.get(code);
			res.add(list);
		}

		return res;
	}

	public static String getCode(String str){
		String code = "";

		for(int i = 1; i < str.length(); i++){
			char chi = str.charAt(i);
			char chim1 = str.charAt(i - 1);
			int diff = chi - chim1;

			if(diff < 0){
				diff += 26;
			}

			code += diff + "*";
		}
		return code;
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

	public static void display(ArrayList<ArrayList<String>> list) {
		for (int i = 0; i < list.size(); i++) {
			ArrayList<String> currList = list.get(i);
			for (int j = 0; j < currList.size(); j++) {
				System.out.print(currList.get(j) + " ");
			}
			System.out.println();
		}
	}

}


// <=================2nd method===================>

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
public class ShiftedStrings {
 
    public static final int ALPHA = 26;
 
    public static String getDiffString(String str) {
        String shift = "";
        for (int i = 1; i < str.length(); i++) {
            int dif = str.charAt(i) - str.charAt(i - 1);
            if (dif < 0)
                dif += ALPHA;
 
            shift += (char)(dif + 'a');
        }
        return shift;
    }
 
    public static void groupShiftedString(String[] str) {
        Map< String, List<Integer> > groupMap = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            String diffStr = getDiffString(str[i]);
            List<Integer> indices = groupMap.getOrDefault(diffStr, new ArrayList<>());
            indices.add(i);
            groupMap.put(diffStr, indices);
        }
 
        for (Map.Entry<String, List<Integer>> entry : groupMap.entrySet()) {
            List<Integer> v = entry.getValue();
            for (int i = 0; i < v.size(); i++)
                System.out.print(str[v.get(i)] + " ");
            System.out.println();
        }
    }
 
    public static void main(String[] args) {
        String[] str = { "acd", "dfg", "wyz", "yab", "mop", "bdfh", "a", "x", "moqs" };
        groupShiftedString(str);
    }
}
 