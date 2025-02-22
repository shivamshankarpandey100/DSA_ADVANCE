//https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/

class Solution {

    int i = 0;
    public TreeNode recoverFromPreorder(String traversal) {
        
        return helper(traversal, 0);

    }

    public TreeNode helper(String str, int depth){

        int d = 0;

        while(i + d < str.length() && str.charAt(i + d) == '-'){
            d++;
        } 

        if(d != depth){
            return null;
        }

        int nd = 0;
        while(i + d + nd < str.length() && str.charAt(i + d + nd) != '-'){
            nd++;
        }

        int val = Integer.parseInt(str.substring(i + d, i + d + nd));
        i = i + d + nd;

        TreeNode node = new TreeNode(val);
        node.left = helper(str, depth + 1);
        if(node.left != null){
            node.right = helper(str, depth + 1);
        }
        
        return node;
    }
}
