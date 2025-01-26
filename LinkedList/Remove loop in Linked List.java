//https://www.geeksforgeeks.org/problems/remove-loop-in-linked-list/1


class Solution {
    public static void removeLoop(Node head) {
        if(head == null || head.next == null) return;
        if(head.next == head){
            head.next = null;
            return;
        }
        Node slow = head, fast = head;
        do {
            slow = slow.next;           
            fast = fast.next.next;      
        } while (fast != null && fast.next != null && fast != slow); 
        if(fast == null || fast.next == null) return;

        Node prev = null;

        slow = head;

        while(slow != fast) {
            prev = fast;     
            fast = fast.next;
            slow = slow.next;
        }

        if(prev == null) {
            do {
                prev = fast;   
                fast = fast.next;
            } while(slow != fast); 
        }
        prev.next = null;
        return;
    }
}

