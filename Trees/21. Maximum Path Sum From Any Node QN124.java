//  https://leetcode.com/problems/binary-tree-maximum-path-sum/
//  https://practice.geeksforgeeks.org/problems/maximum-path-sum-from-any-node/1
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    // TreeNode() {
    // }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        max = Integer.MIN_VALUE;
        maxPathSum_RTN(root);

        return max;
    }

    public int maxPathSum_RTN(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = maxPathSum_RTN(root.left);
        int right = maxPathSum_RTN(root.right);

        int left_dash = Math.max(0, left);
        int right_dash = Math.max(0, right);

        int sumFromLefToRight = left_dash + root.val + right_dash;

        if (sumFromLefToRight > max) {
            max = sumFromLefToRight;
        }

        return Math.max(left_dash, right_dash) + root.val;

    }
}