

//  https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/



import java.util.*;
class Main{

  public static ArrayList<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

    HashMap<Character, ArrayList<Integer>> map = new HashMap<>();

    for (int i = 0; i < 26; i++) {
      map.put((char) ('a' + i), new ArrayList<>());
    }

    for (String word : words) {
      int mask = 0;
      for (char ch : word.toCharArray()) {
        int bit = ch - 'a';
        mask = mask | (1 << bit);
      }

      HashSet<Character> set = new HashSet<>();

      for (char ch : word.toCharArray()) {
        if (set.contains(ch)) {
          continue;
        }

        set.add(ch);
        map.get(ch).add(mask);
      }
    }

    ArrayList<Integer> res = new ArrayList<>();

    for (String puzzle : puzzles) {
      int pmask = 0;
      for (char ch : puzzle.toCharArray()) {
        int bit = ch - 'a';
        pmask = pmask | (1 << bit);
      }

      char fch = puzzle.charAt(0);
      int wordsTocheck = map.get(fch);
      int count = 0;

      for (int wmask : wordsTocheck) {
        if ((wmask & pmask) == wmask) {
          count++;
        }
      }

      res.add(count);
    }

    return res;
  }

}