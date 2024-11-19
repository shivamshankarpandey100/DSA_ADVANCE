//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/construct-bst-from-postorder-traversal/ojquestion
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

    int idx;
    public TreeNode bstFromPreorder(int[] postorder) {

        idx = postorder.length - 1;

        return construct(postorder, Integer.MAX_VALUE);

    }

    public TreeNode construct(int[] postorder, int max){

        if(idx == postorder.length){
            return null;
        }else if(postorder[idx] < max){

            TreeNode node = new TreeNode();

            node.val = postorder[idx];
            idx--;
            
            node.right = construct(postorder, max);
            node.left = construct(postorder, node.val);

            return node;
            
        }else{
            return null;
        }
    }
}