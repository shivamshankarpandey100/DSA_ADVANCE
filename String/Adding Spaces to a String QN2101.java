//https://leetcode.com/problems/adding-spaces-to-a-string

class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();
        int spaceIndex = 0; // Pointer to traverse the spaces array

        for (int i = 0; i < s.length(); i++) {
            // If the current index matches a space position, add a space
            if (spaceIndex < spaces.length && i == spaces[spaceIndex]) {
                result.append(' ');
                spaceIndex++;
            }
            // Append the current character to the result
            result.append(s.charAt(i));
        }

        return result.toString();
    }
}
