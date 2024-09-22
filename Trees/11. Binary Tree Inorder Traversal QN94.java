//  https://practice.geeksforgeeks.org/problems/inorder-traversal/1
//  https://leetcode.com/problems/binary-tree-inorder-traversal/description/
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
  public static void solve(TreeNode root, List<Integer> ans) {

    if (root == null) {
      return;
    }
    solve(root.left, ans);
    ans.add(root.val);
    solve(root.right, ans);
  }
    public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    solve(root, ans);
    return ans;
  }
}
// ---------------------------------------------------->   2nd and old version   <-------------------------------------------------------
class Solution2 {
  public List<Integer> inorderTraversal(TreeNode root) {
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
          iop.right = curr;
          curr = curr.left;
        } else {
          iop.right = null;
          ans.add(curr.val);
          curr = curr.right;
        }
      }
    }

    return ans;
  }
}