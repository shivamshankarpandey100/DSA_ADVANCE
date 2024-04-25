import java.util.*;
public class Main20{
    public static int solution(String str){
        //write code 
        int ans = 0;
        int i = -1;
        int j = -1;
        HashMap<Character, Integer> map = new HashMap<>();
 
        while(true){    // Acquire

            boolean f1 = false;
            boolean f2 = false;

            while(i < str.length() - 1){
                f1 = true;

                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if(map.get(ch) == 2){
                    break;
                }else{
                    int len = i - j;
                    if(len > ans){
                        ans = len;
                    }
                }

            }

            while(j < i){   // Release
                f2 = true;

                j++;
                char ch = str.charAt(j);
                map.put(ch, map.get(ch) - 1);

                if(map.get(ch) == 1){
                    break;
                }
            }
            if(f1 == false && f2 == false){
                break;
            }
        }
		
		return ans;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        System.out.println(solutation(str));
    }
}



//<----------------------------------2nd method------------------------------------>
class Solution{
    static int longestSubstrDistinctChars(String S){
        // code here
        if (S == null || S.length() == 0) {
            return 0;
        }

        int maxLength = 0;
        int start = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();

        for (int end = 0; end < S.length(); end++) {
            char currentChar = S.charAt(end);
            if (charMap.containsKey(currentChar)) {
                start = Math.max(start, charMap.get(currentChar) + 1);
            }
            charMap.put(currentChar, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
