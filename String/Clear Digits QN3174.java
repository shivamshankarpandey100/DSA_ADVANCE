//https://leetcode.com/problems/clear-digits/submissions/
class Solution {
    public String clearDigits(String s) {
        
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch >= '0' && ch <= '9'){
                if(st.size() > 0){
                    st.pop();
                }
            }else{
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (st.size() > 0) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}