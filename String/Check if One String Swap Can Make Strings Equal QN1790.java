//https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/

class Solution {
    public boolean areAlmostEqual(String S1, String S2) {
        int cnt = 0;
        if(S1.length() != S2.length()){
            return false;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for(int k = 0; k < S1.length(); k++){
            if(S1.charAt(k) == S2.charAt(k)){
                continue;
            }else{
                cnt++;
                arr.add(k);
            }
        }

        if(cnt == 0){
            return true;
        }

        if(cnt > 2 || cnt < 2){
            return false;
        }

        if(S1.charAt(arr.get(0)) == S2.charAt(arr.get(1)) && S1.charAt(arr.get(1)) == S2.charAt(arr.get(0))){
            return true;
        }

        return false;
    }
} 
