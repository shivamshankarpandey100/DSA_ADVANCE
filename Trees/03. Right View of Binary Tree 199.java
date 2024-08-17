//  https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1
//  https://leetcode.com/problems/binary-tree-right-side-view/description/
import java.util.*;
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class Solution{
    
    ArrayList<Integer> rightView(Node node) {
        
        ArrayList<Integer> ret = new ArrayList<>();
      
      if(node == null){
          return ret;
      }
      
      Queue<Node> q = new LinkedList<>();
      q.add(node);
      
      while(q.size() > 0){
          int rsize = q.size();
          
          for(int i = 0; i < rsize; i++){
              Node temp = q.remove();
              
              if(i == rsize - 1){
                  ret.add(temp.data);
              }
              
              if(temp.left != null){
                  q.add(temp.left);
              }
              
              if(temp.right != null){
                  q.add(temp.right);
              }
          }
      }
      
      return ret;
    }
}