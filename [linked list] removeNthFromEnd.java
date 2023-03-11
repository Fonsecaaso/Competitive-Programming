public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode newHead = new ListNode(0);
       newHead.next = head;
       ListNode p = newHead;
       ListNode runner = newHead;
       while(n>0){
           runner = runner.next;
           n--;
       }
       while(runner.next!=null){
           runner = runner.next;
           p=p.next;
       }
       p.next = p.next.next;
       return newHead.next;
    }    
}

/*
19. Remove Nth Node From End of List

Given the head of a linked list, remove the nth node from the end of the list and return its head.
*/
