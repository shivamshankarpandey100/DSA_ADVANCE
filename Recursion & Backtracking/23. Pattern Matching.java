import java.util.*;
class Main{

	public static void solution(String str, String pattern, HashMap<Character,String> map, String op){
		
         if(pattern.length() == 0){
             if(str.length() == 0){
                    boolean []vst = new boolean[26];

              for(int i = 0; i < op.length(); i++){
                        char c = op.charAt(i);
                        if(vst[c - 'a'] == false){
                            vst[c - 'a'] = true;
                            System.out.print(c + " -> " + map.get(c) + ",");
                        }
                    }
                    System.out.println(".");
                }
                return;
            }
        
        char ch = pattern.charAt(0);
        String ros = pattern.substring(1);

        if(map.containsKey(ch)){
            String mapped = map.get(ch);
            String txtremain = "-1";

            if(str.length() >= mapped.length()){
                txtremain = str.substring(0, mapped.length());
            }

            if(mapped.equals(txtremain)){
                String ross = str.substring(mapped.length());
                solution(ross, ros, map, op);
            }

        }else{
            for(int i = 0; i < str.length(); i++){
                String left = str.substring(0, i + 1);
                String right = str.substring(i + 1);
                map.put(ch, left);
                solution(right, ros, map, op);
                map.remove(ch);
            }
        }
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		String pattern = scn.next();
		HashMap<Character,String> map = new HashMap<>();
		solution(str,pattern,map,pattern);

        scn.close();
	}
}