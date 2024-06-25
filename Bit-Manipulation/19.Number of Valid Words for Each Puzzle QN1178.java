

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

      for (Character ch : word.toCharArray()) {
        if (set.contains(ch)) {
          continue;
        }

        set.add(ch);
        map.get(ch).add(mask);
      }
    }

    ArrayList<Integer> res = new ArrayList<>();

    for (String puzzle : puzzles) {
      ArrayList<Integer> wordsTocheck = map.get(puzzle.charAt(0));

      int pmask = 0;
      for (Character ch : puzzle.toCharArray()) {
        int bit = ch - 'a';
        pmask = pmask | (1 << bit);
      }

      // char fch = puzzle.charAt(0);
      // int wordsTocheck = map.get(fch);
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


// Time Complexity: O(N * M) where N is the number of words and M is the number of puzzles.
// HashMap<Integer, Integer> wordMaskCount = new HashMap<>();

//         for (String word : words) {
//             int mask = 0;
//             for (char ch : word.toCharArray()) {
//                 mask |= (1 << (ch - 'a'));
//             }

//             if (Integer.bitCount(mask) <= 7) {
//                 wordMaskCount.put(mask, wordMaskCount.getOrDefault(mask, 0) + 1);
//             }
//         }

//         List<Integer> res = new ArrayList<>();

//         for (String puzzle : puzzles) {
//             int pmask = 0;
//             for (char ch : puzzle.toCharArray()) {
//                 pmask |= (1 << (ch - 'a'));
//             }

//             int firstCharMask = 1 << (puzzle.charAt(0) - 'a');
//             int submask = pmask;
//             int count = 0;

//             while (submask > 0) {
//                 if ((submask & firstCharMask) != 0 && wordMaskCount.containsKey(submask)) {
//                     count += wordMaskCount.get(submask);
//                 }
//                 submask = (submask - 1) & pmask;
//             }

//             res.add(count);
//         }

//         return res;