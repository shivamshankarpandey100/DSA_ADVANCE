//https://www.geeksforgeeks.org/problems/pair-with-given-sum-in-a-sorted-array4940/1

class Solution {
    int countPairs(int arr[], int target) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num : arr) {
            int complement = target - num;
            if (map.containsKey(complement)) {
                count += map.get(complement); 
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        return count;
    }
}