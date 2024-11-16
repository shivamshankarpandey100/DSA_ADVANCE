
// Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.
class Solution {
    public static int maxPathSum(Node root) {

        if (root.left != null && root.right != null) {
            int leftsum = maxPathSum(root.left);
            int rightsum = maxPathSum(root.right);

            int left_dash = Math.max(0, leftsum);
            int right_dash = Math.max(0, rightsum);

            int maxsum = Math.max(left_dash, right_dash) + root.data;
            return maxsum;

        } else if (root.left != null) {
            int leftsum = maxPathSum(root.left);
            int left_dash = Math.max(0, leftsum);

            return left_dash + root.data;

        } else if (root.right != null) {
            int rightsum = maxPathSum(root.right);
            int right_dash = Math.max(0, rightsum);

            return right_dash + root.data;

        } else {
            return root.data;
        }
    }
}
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 2nd Approach >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
class Solution2 {
    public static int maxPathSum(Node root) {

        if(root == null){
            return Integer.MIN_VALUE;
        }
        if(root.left == null && root.right == null){
            return root.data;
        }

        int leftsum = maxPathSum(root.left);
        int rightsum = maxPathSum(root.right);

        int left_dash = Math.max(0, leftsum);
        int right_dash = Math.max(0, rightsum);

        int maxsum = Math.max(left_dash, right_dash) + root.data;
        return maxsum;

    }
}