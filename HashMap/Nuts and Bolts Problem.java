// https://www.geeksforgeeks.org/problems/nuts-and-bolts-problem0431/1


class Solution {
    void matchPairs(int n, char nuts[], char bolts[]) {
        char[] order = {'!', '#', '$', '%', '&', '*', '?', '@', '^'};
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length; i++) {
            orderMap.put(order[i], i);
        }
        
        Character[] nutsChar = new Character[n];
        Character[] boltsChar = new Character[n];
        for (int i = 0; i < n; i++) {
            nutsChar[i] = nuts[i];
            boltsChar[i] = bolts[i];
        }
        
        Arrays.sort(nutsChar, new Comparator<Character>() {
            public int compare(Character c1, Character c2) {
                return orderMap.get(c1) - orderMap.get(c2);
            }
        });
        
        Arrays.sort(boltsChar, new Comparator<Character>() {
            public int compare(Character c1, Character c2) {
                return orderMap.get(c1) - orderMap.get(c2);
            }
        });
        
        for (int i = 0; i < n; i++) {
            nuts[i] = nutsChar[i];
            bolts[i] = boltsChar[i];
        }
    }
}