//  https://practice.geeksforgeeks.org/problems/inorder-successor-in-bst/1
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

class Solution {

    public Node inorderSuccessor(Node root, Node x) {
        Node curr = root;
        Node succ = null;
        boolean found = false;

        while (curr != null) {
            if (curr.left == null) {
                if (found == true) {
                    succ = curr;
                    break;
                }

                if (curr == x) {
                    found = true;
                }

                curr = curr.right;
            } else {
                Node iop = curr.left;
                while (iop.right != null && iop.right != curr) {
                    iop = iop.right;
                }

                if (iop.right == null) {
                    iop.right = curr;
                    curr = curr.left;
                } else {
                    if (found == true) {
                        succ = curr;
                        break;
                    }

                    if (curr == x) {
                        found = true;
                    }

                    iop.right = null;
                    curr = curr.right;
                }
            }
        }

        return succ;
    }
}