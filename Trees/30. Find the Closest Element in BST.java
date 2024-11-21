//   https://practice.geeksforgeeks.org/problems/find-the-closest-element-in-bst/1
class Node  { 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}
class Solution{

    static int minD;
    static int minDiff(Node  root, int k) 
    { 
        minD = Integer.MAX_VALUE;

        travel(root, k);

        return minD;
    } 

    static void travel(Node node, int k){

        if(node == null){
            return;
        }

        int diff = Math.abs(node.data - k);
        if(diff < minD){
            minD = diff;
        }

        if(k > node.data){
            travel(node.right, k);
        }else if(k < node.data){
            travel(node.left, k);
        }else{
            return;
        }
    }
}