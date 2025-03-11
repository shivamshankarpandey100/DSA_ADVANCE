//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters

class Solution {
    public int numberOfSubstrings(String s) {
        char[]arr = s.toCharArray();
        int N = s.length();
        
        return helper(arr, N, 3) - helper(arr, N, 2);
    }

    static int helper(char arr[], int n, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int cnt = 0;
        int i = 0, j = 0;

        while (i < n && j < n) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);

            while (map.size() > k) {
                map.put(arr[i], map.get(arr[i]) - 1);

                if (map.get(arr[i]) == 0) {
                    map.remove(arr[i]);
                }

                i++;
            }

            if (map.size() <= k) {
                cnt += (j - i) + 1;
            }

            j++;
        }

        return cnt;
    }
}