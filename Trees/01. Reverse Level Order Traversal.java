//  https://practice.geeksforgeeks.org/problems/reverse-level-order-traversal/1
class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        ArrayList<Integer> ret = new ArrayList<>();
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        
        Stack<Integer> st = new Stack<>();
        while(queue.size() > 0){
            Node temp = queue.remove();
            st.push(temp.data);
            
            if(temp.right != null){
                queue.add(temp.right);
            }
            
            if(temp.left != null){
                queue.add(temp.left);
            }
        }
        while(st.size() > 0){
            int val = st.pop();
            ret.add(val);
        }
        return ret;
    }
}