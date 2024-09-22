//  https://leetcode.com/problems/binary-tree-coloring-game/
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        left=null;
        right=null;
    }
}
class Solution {

    int xkaleft;
    int xkaright;
    public int size(TreeNode node, int x){

        if(node == null){
            return 0;
        }
        int ls = size(node.left, x);
        int rs = size(node.right, x);

        if(node.val == x){
            xkaleft = ls;
            xkaright = rs;
        }

        int ts = ls + rs + 1;
        return ts;
    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        
        size(root, x);

        int remSide = n - (xkaleft + xkaright + 1);
        int maxSize = Math.max(remSide, Math.max(xkaleft, xkaright));

        int rest = n - maxSize;

        if(maxSize > rest){
            return true;
        }else{
            return false;
        }
    }
}