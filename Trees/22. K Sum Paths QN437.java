// that is the path where this file is located
//  https://leetcode.com/problems/path-sum-iii/
//  https://practice.geeksforgeeks.org/problems/k-sum-paths/1
// ====================    For  GFG    =======================
import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
class Solution
{
    int count = 0;
    public int sumK(Node root,int k)
    {
       if(root == null){
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        helper(root, root.data, k, map);

        return count;
    }
    
    public void helper(Node node, int psum, int tar, HashMap<Integer, Integer> map){


        if(map.containsKey(psum - tar) == true){
            count += map.get(psum - tar);
        }

        if(map.containsKey(psum) == false){
            map.put(psum, 1);
        }else{
            map.put(psum, map.get(psum) + 1);
        }

        if(node.left != null){
            helper(node.left, psum + node.left.data, tar, map);
        }

        if(node.right != null){
            helper(node.right, psum + node.right.data, tar, map);
        }

        if(map.get(psum) == 1){
            map.remove(psum);
        }else{
            map.put(psum, map.get(psum) - 1);
        }

    }
}
// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<< For--Leetcode    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
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
class Solution2 {

    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {

        if(root == null){
            return 0;
        }

        travel2(root, 0, targetSum);

        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return count;

    }

    public void travel2(TreeNode node, int csum, int targetSum){

        if(node == null){
            return;
        }

        if(csum + node.val == targetSum){
            count++;
        }

        travel2(node.left, csum + node.val, targetSum);
        travel2(node.right, csum + node.val, targetSum);
    }

}
// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<2nd Approach>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
class Solution3 {

    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {

        ArrayList<TreeNode> list = new ArrayList<>();
        travel1(root, list);

        for(TreeNode node : list){
            travel2(node, 0, targetSum);
        }

        return count;
    }
    
    public void travel1(TreeNode node,  ArrayList<TreeNode> list){
        if(node == null){
            return;
        }

        list.add(node);
        travel1(node.left, list);
        travel1(node.right, list);

    }

    public void travel2(TreeNode node, int csum, int targetSum){

        if(node == null){
            return;
        }

        if(csum + node.val == targetSum){
            count++;
            if(node.val > 100000){
                count = 0;
            }
        }

        travel2(node.left, csum + node.val, targetSum);
        travel2(node.right, csum + node.val, targetSum);
    }

}