//  https://practice.geeksforgeeks.org/problems/preorder-traversal-iterative/1
//  https://practice.geeksforgeeks.org/problems/inorder-traversal-iterative/1
//  https://practice.geeksforgeeks.org/problems/postorder-traversal-iterative/1
import java.util.*;
class Solution {
    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void iterativePrePostInTraversal(Node node) {

        Pair p = new Pair(node, 0);
        Stack<Pair> st = new Stack<>();

        st.push(p);

        String pre = "";
        String in = "";
        String post = "";

        while (st.size() > 0) {
            Pair top = st.peek();

            if (top.state == 0) {
                pre += top.node.data + " ";

                if (top.node.left != null) {
                    Pair rp = new Pair(top.node.left, 0);
                    st.push(rp);
                }
            } else if (top.state == 1) {
                in += top.node.data + " ";

                if (top.node.right != null) {
                    Pair lp = new Pair(top.node.right, 0);
                    st.push(lp);
                }
            } else {
                post += top.node.data + " ";
                st.pop();
            }

            top.state++;
        }

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

}



//---------------------------------Solution of all three(pre in post) of gfg solutation traversals in one function---------------------------------

public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    ArrayList<Integer> iterativePrePostInTraversal(Node root)//name of the function is changed to iterativePrePostInTraversal acording to the gfg solution
    {
         Pair p = new Pair(root, 0);
        Stack<Pair> st = new Stack<>();

        st.push(p);

        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();

        while (st.size() > 0) {
            Pair top = st.peek();

            if (top.state == 0) {
                pre.add(top.node.data);

                if (top.node.left != null) {
                    Pair rp = new Pair(top.node.left, 0);
                    st.push(rp);
                }
            } else if (top.state == 1) {
                in.add(top.node.data);

                if (top.node.right != null) {
                    Pair lp = new Pair(top.node.right, 0);
                    st.push(lp);
                }
            } else {
                post.add(top.node.data);
                st.pop();
            }

            top.state++;
        }

        return(pre);
        return(in);
        return(post);
    }