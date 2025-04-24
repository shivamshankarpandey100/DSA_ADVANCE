//https://www.geeksforgeeks.org/problems/find-element-occuring-once-when-all-other-are-present-thrice/1

class Solution {
    public int getSingle(int[] arr) {
        // code here
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        for(Map.Entry<Integer,Integer> mp:map.entrySet()){
            if(mp.getValue()==1)
                return mp.getKey();
        }
        return -1;
    }
}