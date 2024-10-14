//  https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
//  https://practice.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/1
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
TreeNode() {
    }
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        TreeNode root = construct(inorder, postorder, 0, postorder.length - 1, 0, inorder.length - 1);
        return root;
    }
public TreeNode construct(int[] inorder, int[] postorder, int post_lo, int post_hi, int in_lo, int in_hi) {

        if (post_lo > post_hi || in_lo > in_hi) {
            return null;
        }
        TreeNode node = new TreeNode();

        int idx = in_lo;
        while (idx <= in_hi) {
            if (inorder[idx] == postorder[post_hi]) {
                break;
            }
            idx++;
        }

        int rhs = in_hi - idx;
        node.val = postorder[post_hi];
        node.left = construct(inorder, postorder, post_lo, post_hi - rhs - 1, in_lo, idx - 1);
        node.right = construct(inorder, postorder, post_hi - rhs, post_hi - 1, idx + 1, in_hi);

        return node;
    }
}