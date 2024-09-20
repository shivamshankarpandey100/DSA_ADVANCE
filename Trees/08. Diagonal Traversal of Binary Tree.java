//  https://practice.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1
import java.util.*;
class Node {
     int data;
     Node left;
     Node right;

     Node(int data) {
          this.data = data;
          left = null;
          right = null;
     }
}

class Tree2 {
     public ArrayList<Integer> diagonal(Node root) {
          ArrayList<Integer> ans = new ArrayList<>();
          Queue<Node> queue = new LinkedList<>();
          queue.add(root);

          while (queue.size() > 0) {
               int n = queue.size();

               for (int i = 0; i < n; i++) {
                    Node rem = queue.remove();

                    while (rem != null) {
                         ans.add(rem.data);

                         if (rem.left != null) {
                              queue.add(rem.left);
                         }

                         rem = rem.right;
                    }
               }

          }

          return ans;
     }
}


// -------------------------------------->     2nd and old method     <---------------------------------------


class Tree {
     static int md = 0;

     static void traversal(Node root, int diag, HashMap<Integer, ArrayList<Integer>> map) {

          if (root == null) {
               return;
          }

          if (diag > md) {
               md = diag;
          }

          if (map.containsKey(diag) == false) {
               map.put(diag, new ArrayList<>());
               map.get(diag).add(root.data);
          } else {
               map.get(diag).add(root.data);
          }

          traversal(root.left, diag + 1, map);
          traversal(root.right, diag, map);
     }

     public ArrayList<Integer> diagonal(Node root) {
          HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
          traversal(root, 0, map);

          ArrayList<Integer> total = new ArrayList<>();
          for (int d = 0; d <= md; d++) {
               ArrayList<Integer> list = map.get(d);

               if (list == null) {
                    continue;
               }

               for (int item : list) {
                    total.add(item);
               }
          }
          return total;
     }
}
