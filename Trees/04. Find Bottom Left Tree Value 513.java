

//  https://leetcode.com/problems/find-bottom-left-tree-value/description/



import java.util.*;
class TreeNode
{
    int val;
    TreeNode left, right;

    TreeNode(int item)
    {
        val = item;
        left = right = null;
    }
}
class Solution {
    public int findBottomLeftValue(TreeNode root) {
      
      int ret = 0;
      int lc = 0;
      int ht = height(root);

      if(root == null){
          return ret;
      }
      
      Queue<TreeNode> q = new LinkedList<>();
      q.add(root);
      
      while(q.size() > 0){
          int rsize = q.size();
          
          for(int i = 0; i < rsize; i++){
              TreeNode temp = q.remove();
              
              if(i == 0 && lc == ht){
                  ret = temp.val;
              }
              
              if(temp.left != null){
                  q.add(temp.left);
              }
              
              if(temp.right != null){
                  q.add(temp.right);
              }
          }
          lc++;
      }
      
      return ret;
    }

    public static int height(TreeNode root) {
    if(root == null){
      return -1;
    }
    
    int lh = height(root.left);
    int rh = height(root.right);
    int th = Math.max(lh, rh) + 1;
    return th;
  }
}