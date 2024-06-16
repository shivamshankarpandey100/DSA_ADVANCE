// https://leetcode.com/problems/gray-code/description/


import java.util.*;
class Main{

    public static List<Integer> grayCode(int n) {

        if (n == 0) {
            List<Integer> bres = new ArrayList<>();
            bres.add(0);

            return bres;
        } else if (n == 1) {
            List<Integer> bres = new ArrayList<>();
            bres.add(0);
            bres.add(1);

            return bres;
        }

        List<Integer> rres = grayCode(n - 1); // rres = recursion result
        List<Integer> mres = new ArrayList<>(); // mres = my result

        for (int i = 0; i < rres.size(); i++) {
            int val = rres.get(i);
            mres.add(val);
        }

        for (int i = rres.size() - 1; i >= 0; i--) {
            int val = rres.get(i);

            int bm = 1 << (n - 1);
            val = val | bm;

            mres.add(val);
        }

        return mres;
    }

}