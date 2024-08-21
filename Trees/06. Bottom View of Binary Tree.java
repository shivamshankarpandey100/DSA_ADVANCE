// https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
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
class Solution
{
    static class Pair {
        Node node;
        int horiz = 0;
    }
    
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        
        HashMap<Integer, Node> map = new HashMap<>();
        
        int lv = 0;
        int rv = 0;
        
        Queue<Pair> q = new LinkedList<>();
        Pair p = new Pair();
        p.node = root;
        p.horiz = 0;
        
        q.add(p);
        
        while(q.size() > 0){
            Pair temp = q.remove();
            
            if(temp.horiz < lv){
                lv = temp.horiz;
            }
            if(temp.horiz > rv){
                rv = temp.horiz;
            }
            
            map.put(temp.horiz, temp.node);
            
            if(temp.node.left != null){
                Pair lp = new Pair();
                lp.node = temp.node.left;
                lp.horiz = temp.horiz - 1;
                
                q.add(lp);
            }
            
            if(temp.node.right != null){
                Pair rp = new Pair();
                rp.node = temp.node.right;
                rp.horiz = temp.horiz + 1;
                
                q.add(rp);
            }
        }
        
        for(int i = lv; i <= rv; i++){
            ans.add(map.get(i).data);
        }
        
        return ans;
    }
}


