

//   https://leetcode.com/problems/insert-delete-getrandom-o1/


import java.util.*;
class RandomizedSet {

    Random r;
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;

    public RandomizedSet() {
        r = new Random();
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }

        list.add(val);
        map.put(val, list.size() - 1);

        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }

        int vidx = map.get(val);
        int lidx = list.size() - 1;
        int lval = list.get(lidx);
        
        list.set(vidx, lval);
        list.set(lidx, val);
        map.put(val, lidx);
        map.put(lval, vidx);

        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }
    
    public int getRandom() {
        int idx = r.nextInt(list.size());
        return list.get(idx);
    }
}