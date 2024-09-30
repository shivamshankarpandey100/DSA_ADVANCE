

// https://leetcode.com/problems/recover-binary-search-tree/

//  https://practice.geeksforgeeks.org/problems/6c4053871794c5e7a0817d7eaf88d71c4bb4c2bc/1

//  https://practice.geeksforgeeks.org/problems/fixed-two-nodes-of-a-bst/1


class Solution {
    public void recoverTree(TreeNode root) {
        
        TreeNode curr = root;
        TreeNode pre = null;

        TreeNode n1 = null;
        TreeNode n2 = null;

        while (curr != null) {
            if (curr.left == null) {
                if(pre != null){
                    if(curr.val < pre.val){
                        if(n1 == null){
                            n1 = pre;
                            n2 = curr;
                        }else{
                            n2 = curr;
                        }
                    }
                }

                pre = curr;
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
                    if(curr.val < pre.val){
                        if(n1 == null){
                            n1 = pre;
                            n2 = curr;
                        }else{
                            n2 = curr;
                        }
                    }

                    pre = curr;
                    iop.right = null;
                    curr = curr.right;
                }
            }
        }
        
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;

    }
}