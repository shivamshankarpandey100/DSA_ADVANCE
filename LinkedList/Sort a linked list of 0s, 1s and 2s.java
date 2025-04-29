// https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1

class Solution {
    static Node segregate(Node head) {
        // code here
         Node temp=head;
     int zero=0,one=0,two=0;
     while(temp!=null){
         if(temp.data==0)
         zero++;
         else if(temp.data==1)
         one++;
         else
         two++;
         temp=temp.next;
     }
     temp=head;
     while(zero!=0){
         temp.data=0;
         temp=temp.next;
         zero--;
     }
     while(one!=0){
         temp.data=1;
         temp=temp.next;
         one--;
     }
     while(two!=0){
         temp.data=2;
         temp=temp.next;
         two--;
     }
        return head;
    }
}