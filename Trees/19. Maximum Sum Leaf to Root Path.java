//  https://practice.geeksforgeeks.org/problems/maximum-sum-leaf-to-root-path/1
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
class Solution {
    public static int maxPathSum(Node root) {

        if (root.left != null && root.right != null) {
            int leftsum = maxPathSum(root.left);
            int rightsum = maxPathSum(root.right);
            int maxsum = Math.max(leftsum, rightsum) + root.data;
            return maxsum;
        } else if (root.left != null) {
            int leftsum = maxPathSum(root.left);
            return leftsum + root.data;
        } else if (root.right != null) {
            int rightsum = maxPathSum(root.right);
            return rightsum + root.data;
        } else {
            return root.data;
        }
    }
}
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<2ND>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
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

        int maxsum = Math.max(leftsum, rightsum) + root.data;
        return maxsum;

    }
}