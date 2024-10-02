//  https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
//  https://practice.geeksforgeeks.org/problems/construct-tree-1/1
import java.util.*;
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < inorder.length; i++){
            int val = inorder[i];
            map.put(val, i);
        }

        TreeNode root = construct(0, preorder.length - 1, 0, inorder.length - 1, preorder, map);
        return root;
    }
public TreeNode construct(int pre_lo, int pre_hi, int in_lo, int in_hi, int []preorder, HashMap<Integer, Integer> map){

        if(pre_lo > pre_hi || in_lo > in_hi){
            return null;
        }

        TreeNode node = new TreeNode();
        node.val = preorder[pre_lo];

        int idx = map.getOrDefault(preorder[pre_lo], 0);
        int lhs = idx - in_lo;
        node.left = construct(pre_lo + 1, pre_lo + lhs, in_lo, idx - 1, preorder, map);
        node.right = construct(pre_lo + lhs + 1, pre_hi, idx + 1, in_hi, preorder, map);

        return node;
    }
}

//----------------------------------------->gfg solution<-----------------------------------------
class Solution
{
    int preIndex = 0; public Node buildTree(int inorder[], int preorder[], int n) {
        return buildTreeHelper(inorder, preorder, 0, n - 1);
    }
    
    public Node buildTreeHelper(int[] inorder, int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        
        int currentVal = preorder[preIndex++];
        
        Node root = new Node(currentVal);
        
        if (inStart == inEnd) {
            return root;
        }
        
        int inIndex = search(inorder, inStart, inEnd, currentVal);
        root.left = buildTreeHelper(inorder, preorder, inStart, inIndex - 1);
        root.right = buildTreeHelper(inorder, preorder, inIndex + 1, inEnd);
        
        return root;
    }
    public int search(int[] inorder, int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
