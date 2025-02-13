//https://www.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1

class Solution {
    boolean findTarget(Node root, int target) {
        return hasPairWithSum(root, target, new HashSet<>());
    }

    private boolean hasPairWithSum(Node root, int target, HashSet<Integer> set) {
        if (root == null) return false;

        if (hasPairWithSum(root.left, target, set)) return true;

        if (set.contains(target - root.data)) return true;

        set.add(root.data);

        return hasPairWithSum(root.right, target, set);
    }
}