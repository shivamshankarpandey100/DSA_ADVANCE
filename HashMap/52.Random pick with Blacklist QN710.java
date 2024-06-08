

//  https://leetcode.com/problems/random-pick-with-blacklist/


import java.util.*;
class Solution {

    HashMap<Integer, Integer> map;
    Random r;
    int top;

    public Solution(int n, int[] blacklist) {
    
        map = new HashMap<>();
        r = new Random();//it is use to generate random number in the range of 0 to top or given range
        top = n - blacklist.length;//top is the range of random number which we can generate

        HashSet<Integer> set = new HashSet<>();//it is use to store the blacklisted number
        for(int i = 0; i < blacklist.length; i++){
            set.add(blacklist[i]);//store the blacklisted number in the set
        }
        n--;

        for(int i = 0; i < blacklist.length; i++){
            if(blacklist[i] < top){//if the blacklisted number is less than top then we can directly map it to the n
                while(set.contains(n) == true){
                    n--;
                }

                map.put(blacklist[i], n);
                n--;
            }
        }
    }
    
    public int pick() {
      
        int randidx = r.nextInt(top);
        if(map.containsKey(randidx)){
            return map.get(randidx);
        }

        return randidx;
    }
}