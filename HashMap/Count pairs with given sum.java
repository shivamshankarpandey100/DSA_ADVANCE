//https://www.geeksforgeeks.org/problems/count-pairs-with-given-sum--150253/1

class Solution {

    int countPairs(int arr[], int target) {
        Hashtable<Integer, Integer> freq = new Hashtable<>();
        int count = 0;
        
        for (int num: arr) {
            if (freq.containsKey(target - num)) count += freq.get(target - num);
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        return count;
    }
}