

//   https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/


import java.util.*;
class RandomizedCollection {

    Random rand;
    HashMap<Integer, HashSet<Integer>> map;
    ArrayList<Integer> list;

    public RandomizedCollection() {
        rand = new Random();
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        
        list.add(val);
        int lidx = list.size() - 1;

        if(map.containsKey(val)){
            HashSet<Integer> set = map.get(val);
            set.add(lidx);

            return false;
        }else{
            HashSet<Integer> set = new HashSet<>();
            set.add(lidx);
            map.put(val, set);

            return true;
        }
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }

        int lidx = list.size() - 1;
        int lval = list.get(lidx);
        int vidx = map.get(val).iterator().next();

        list.set(lidx, val);
        list.set(vidx, lval);

        list.remove(lidx);
        
        map.get(val).remove(vidx);
        if(map.get(val).size() == 0){
            map.remove(val);
        }

        if(map.containsKey(lval)){
            map.get(lval).remove(lidx);
            map.get(lval).add(vidx);
        }

        return true;
    }
    
    public int getRandom() {
        int idx = rand.nextInt(list.size());
        return list.get(idx);
    }
}