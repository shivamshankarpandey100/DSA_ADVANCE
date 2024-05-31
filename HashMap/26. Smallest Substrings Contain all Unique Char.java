import java.util.*;
class Main {

	public static int solution(String str){
		
        int len = str.length();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            set.add(ch);
        }

        int i = -1; 
        int j = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        while(true){
            boolean f1 = false;
            boolean f2 = false;

            while(i < str.length() - 1 && map.size() < set.size()){
                f1 = true;
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            while(j < i && map.size() == set.size()){
                f2 = true;
                int plen = i - j;
                if(plen < len){
                    len = plen;
                }

                j++;
                char ch = str.charAt(j);
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch) - 1);
                }
            }
            if(f1 == false && f2 == false){
                break;
            }
        }

		return len;
	}
}