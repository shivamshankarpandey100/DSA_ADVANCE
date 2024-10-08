//  https://leetcode.com/problems/binary-tree-preorder-traversal/description/
//  https://practice.geeksforgeeks.org/problems/preorder-traversal/1
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class Solution {
    static void solve(TreeNode root, List<Integer> ans) {

        if (root == null) {
            return;
        }

        ans.add(root.val);
        solve(root.left, ans);
        solve(root.right, ans);

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        solve(root, ans);

        return ans;

    }
}


// ------------------------------------------->2nd Version<--------------------------------------------------------------
class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                ans.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode iop = curr.left;
                while (iop.right != null && iop.right != curr) {
                    iop = iop.right;
                }

                if (iop.right == null) {
                    ans.add(curr.val);
                    iop.right = curr;
                    curr = curr.left;
                } else {
                    iop.right = null;
                    curr = curr.right;
                }
            }
        }

        return ans;
    }
}


//----------------------------------------------->solution of GFG code <---------------------------------------------------
class BinaryTree
{
    public static void solve(Node root,ArrayList<Integer>ans){
        if(root==null){
            return;
        }
        
        ans.add(root.data);
        solve(root.left , ans);
        solve(root.right , ans);
    }
    
    static ArrayList<Integer> preorder(Node root)
    {
        ArrayList<Integer>ans=new ArrayList<>();
        solve(root,ans);
        return ans;
    }

}