//  https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
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
    void leftWall(Node node, ArrayList<Integer> list){

        if(node == null){
            return;
        }

        if(node.left != null || node.right != null){
            list.add(node.data);
        }

        if(node.left != null){
            leftWall(node.left, list);
        }else if(node.right != null){
            leftWall(node.right, list);
        }
    }

    void leaves(Node node, ArrayList<Integer> list){
        if(node == null){
            return;
        }

        leaves(node.left, list);

        if(node.left == null && node.right == null){
            list.add(node.data);
        }

        leaves(node.right, list);
    }

    void rightWall(Node node, ArrayList<Integer> list){
        if(node == null){
            return;
        }

        if(node.right != null){
            rightWall(node.right, list);
        }else if(node.left != null){
            rightWall(node.left, list);
        }

        if(node.left != null || node.right != null){
            list.add(node.data);
        }
    }
    ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> list = new ArrayList<>();

        list.add(node.data);

        leftWall(node.left, list);
        
        leaves(node.left, list);
        leaves(node.right, list);

        rightWall(node.right, list);

        return list;
	}
}

 