//https://www.geeksforgeeks.org/problems/find-k-th-smallest-element-in-bst/1

class Solution {
    public int kthSmallest(Node root, int k) {
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            k--; 
            if (k == 0) {
                return current.data;
            }

            current = current.right;
        }

        return -1;
    }
}
