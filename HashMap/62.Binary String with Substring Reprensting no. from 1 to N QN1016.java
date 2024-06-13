

//  https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/description/


class Main61 {
	public static boolean solution(String str, int n) {
		 for (int i = n; i > n / 2; i--) {
            if (!str.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }

}