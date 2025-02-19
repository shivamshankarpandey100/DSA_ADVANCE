//https://www.geeksforgeeks.org/problems/merge-k-sorted-linked-lists/1

class Solution {
    // Function to merge K sorted linked list.
    Node mergeKLists(List<Node> arr) {
        // Add your code here.
        List<Integer> list = new ArrayList<>() ; 
        for(int i = 0 ; i<arr.size() ; i++){
           Node temp = arr.get(i);
           while(temp!= null){
               list.add(temp.data);
               temp = temp.next ; 
           }
        }
        Collections.sort(list) ; 
        Node head = new Node(0) ; 
        Node temp = head ; 
        int i = 0 ; 
        while(i<list.size()){
            temp.next = new Node(list.get(i));
             temp = temp.next ; 
             i++ ; 
        }
        return head.next ; 
    }
}