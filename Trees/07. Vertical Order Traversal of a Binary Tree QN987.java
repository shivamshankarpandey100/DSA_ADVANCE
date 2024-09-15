

//  https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

//  https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1


import java.util.*;
class TreeNode
{
    int val;
    TreeNode left, right;
    TreeNode(int item){
        val = item;
        left = right = null;
}
}
class Solution {

    static class Pair implements Comparable<Pair> {
        TreeNode node;
        int w;
        int d;

        Pair(TreeNode node, int w, int d){
            this.node = node;
            this.w = w;
            this.d = d;
        }
    public int compareTo(Pair other){
            if(this.d == other.d){
                return this.node.val - other.node.val;
            }else{
                return this.d - other.d;
            }
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 1));
        int lmw = 0;
        int rmw = 0;
        HashMap<Integer,ArrayList<Pair>> map = new HashMap<>();

        while(q.size() > 0){
            Pair temp = q.remove();

            if(temp.w < lmw){
                lmw = temp.w;
            }
            if(temp.w > rmw){
                rmw = temp.w;
            }

            if(map.containsKey(temp.w) == false){
                map.put(temp.w, new ArrayList<>());
                map.get(temp.w).add(temp);
            }else{
                map.get(temp.w).add(temp);
            }

            if(temp.node.left != null){
                q.add(new Pair(temp.node.left, temp.w - 1, temp.d + 1));
            }
            if(temp.node.right != null){
                q.add(new Pair(temp.node.right, temp.w + 1, temp.d + 1));
            }
            }
        List<List<Integer>> res = new ArrayList<>();
        int idx = 0;
        for(int w = lmw; w <= rmw; w++){
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<Pair> unsortedList = map.get(w);
            Collections.sort(unsortedList);

            for(Pair temp : unsortedList){
                list.add(temp.node.val);
            }
            res.add(list);
            idx++;
        }

        return res;
    }
}