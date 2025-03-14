//   https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
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

    int idx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        
        return construct(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    public TreeNode construct(int [] pre, int min, int max){

        if(idx == pre.length){
            return null;
        }else if(pre[idx] > min && pre[idx] < max){

            TreeNode node = new TreeNode();

            node.val = pre[idx];
            idx++;

            node.left = construct(pre, min, node.val);
            node.right = construct(pre, node.val, max);

            return node;

        }else{
            return null;
        }
    }
}
// <===================================================2nd Solutation=============================================================>
class Solution2 {

    int idx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        
        return construct(preorder, Integer.MAX_VALUE);

    }

    public TreeNode construct(int [] pre, int max){

        if(idx == pre.length){
            return null;
        }else if(pre[idx] < max){

            TreeNode node = new TreeNode();

            node.val = pre[idx];
            idx++;

            node.left = construct(pre, node.val);
            node.right = construct(pre, max);

            return node;

        }else{
            return null;
        }
    }
}