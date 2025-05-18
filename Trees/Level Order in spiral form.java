//https://www.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1

class Solution {
    public ArrayList<Integer> findSpiral(Node root) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Stack<Node> s1 = new Stack<>(); 
        Stack<Node> s2 = new Stack<>(); 
        
        // Push first level to first stack 's1'
        s1.push(root);

        // Keep printing while any of the stacks has some nodes
        while (!s1.isEmpty() || !s2.isEmpty()) {

            // Print nodes of current level from s1 and 
            // push nodes of next level to s2
            while (!s1.isEmpty()) {
                Node temp = s1.pop();
                res.add(temp.data);

                // Note that right child is pushed before left
                if (temp.right != null)
                    s2.push(temp.right);
                if (temp.left != null)
                    s2.push(temp.left);
            }

            // Print nodes of current level from s2 and 
            // push nodes of next level to s1
            while (!s2.isEmpty()) {
                Node temp = s2.pop();
                res.add(temp.data);

                // Note that left child is pushed before right
                if (temp.left != null)
                    s1.push(temp.left);
                if (temp.right != null)
                    s1.push(temp.right);
            }
        }

        return res;
    }
}