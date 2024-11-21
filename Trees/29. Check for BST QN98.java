//  https://leetcode.com/problems/validate-binary-search-tree/
//  https://practice.geeksforgeeks.org/problems/check-for-bst/1
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {

    boolean isBSt = true;
    public boolean isValidBST(TreeNode root) {
        
        helper(root, Long.MIN_VALUE, Long.MAX_VALUE);

        return isBSt;
    }

    public void helper(TreeNode root, long min, long max){

        if(root == null){
            return;
        }

        if(root.val <= min || root.val >= max){
            isBSt = false;
        }

        if(root.left != null){
            helper(root.left, min, root.val);
        }

        if(root.right != null){
            helper(root.right, root.val, max);
        }
        
    }
}

//--------------------------------2nd Approach--------------------------------
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
        left=null;
        right=null;
    }

}
class Solution {
    boolean isBST(Node root) {
        int min=Integer.MIN_VALUE;
        int max=Integer.MAX_VALUE;
        return bst(root,min,max);
    }
    public static boolean bst(Node root,int min,int max){
        if(root == null) return true;
        if(root.data<=min || root.data>=max) return false;
        return bst(root.left,min,root.data) && bst(root.right,root.data,max);
    }
    
}