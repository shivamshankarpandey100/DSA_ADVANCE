import java.util.*;
class Main {
    public static int size(String root, HashMap<String, ArrayList<String>> tree, HashMap<String, Integer> res) {
        if (tree.containsKey(root) == false) {
            res.put(root, 0);
            return 1;
        }

        int sz = 0;
        for (String child : tree.get(root)) {
            int cs = size(child, tree, res);
            sz += cs;
        }

        res.put(root, sz);
        return sz + 1;

    }