import java.util.*;
// https://leetcode.com/problems/powerful-integers/
class Main{

     public List<Integer> powerfulIntegers(int x, int y, int bound) {

        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        if (bound <= 1) {
            return list;
        } else if (x == 1 && y == 1) {
            list.add(2);
        } else if (x == 1) {
            for (int vy = 1; vy < bound; vy *= y) {
                int val = 1 + vy;
                if (set.contains(val) == false) {
                    set.add(val);
                    list.add(val);
                }
            }
        } else if (y == 1) {
            for (int vx = 1; vx < bound; vx *= x) {
                int val = vx + 1;
                if (set.contains(val) == false) {
                    set.add(val);
                    list.add(val);
                }
            }
        } else {
            for (int vx = 1; vx < bound; vx *= x) {
                for (int vy = 1; vx + vy <= bound; vy *= y) {
                    int val = vx + vy;
                    if (set.contains(val) == false) {
                        set.add(val);
                        list.add(val);
                    }
                }
            }
        }

        return list;
    }
}