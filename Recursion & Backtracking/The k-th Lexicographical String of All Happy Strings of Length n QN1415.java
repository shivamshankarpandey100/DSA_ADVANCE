//https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/

class Solution {
    public String getHappyString(int length, int position) {
        StringBuilder result = new StringBuilder();
        int totalCombinations = (int) Math.pow(2, length - 1);
        if (totalCombinations * 3 < position) return "";

        int firstSegment = totalCombinations, secondSegment = totalCombinations * 2;
        if (position <= firstSegment) {
            result.append('a');
        } else if (position > secondSegment) {
            result.append('c');
            position -= secondSegment;
        } else {
            result.append('b');
            position -= firstSegment;
        }

        while (result.length() < length) {
            int halfSegment = totalCombinations / 2;
            if (position <= halfSegment) {
                result.append(result.charAt(result.length() - 1) == 'a' ? 'b' : 'a');
            } else {
                result.append(result.charAt(result.length() - 1) == 'c' ? 'b' : 'c');
                position -= halfSegment;
            }
            totalCombinations /= 2;
        }

        return result.toString();
    }
}
