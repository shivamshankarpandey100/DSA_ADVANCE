//https://www.geeksforgeeks.org/problems/non-repeating-character-1587115620/1

class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // Your code here
        char ch;
        for(int i=0;i<s.length();i++){
            ch=s.charAt(i);
            if(s.lastIndexOf(ch)==s.indexOf(ch))
            return ch;
        }
        return '$';
    }
}