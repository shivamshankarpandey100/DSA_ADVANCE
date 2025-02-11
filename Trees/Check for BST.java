//https://www.geeksforgeeks.org/problems/check-for-bst/1

class Solution {
    boolean isBST(Node root) {
    return helper(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
    Boolean helper(Node root,int max,int min){
        if(root==null){
            return true;
        }
         
         if(root.data<min||root.data>max){
             return false;
         }
         
        return helper(root.left,root.data,min)&&helper(root.right,max,root.data); 

    }
    
}