

//  https://leetcode.com/problems/avoid-flood-in-the-city/


import java.util.*;
class Solution {
    public int[] avoidFlood(int[] rains) {
        
        HashMap<Integer, Integer> rainyDay = new HashMap<>();
        TreeSet<Integer> dry = new TreeSet<>();

        int n = rains.length;
        int ans[] = new int[n];

        for(int i = 0; i < n; i++){
            int x = rains[i];

            if(x == 0){
                dry.add(i);
                ans[i] = 1;
            }else{
                Integer id = rainyDay.get(x);
                if(id == null){
                    rainyDay.put(x, i);
                }else{
                    Integer dayDay = dry.higher(id);

                    if(dayDay == null){
                        return new int[0];
                    }

                    ans[dayDay] = x;
                    dry.remove(dayDay);

                    rainyDay.put(x, i);
                }

                ans[i] = -1;
            }
        }

        return ans;
    }
}