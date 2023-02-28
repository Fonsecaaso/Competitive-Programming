class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode sl1=l1, sl2=l2;
        ListNode head=new ListNode(0);
        ListNode newnode=head;
        while(sl1!=null && sl2!=null){            
            if(sl1.val<sl2.val){
                newnode.next=sl1;
                sl1=sl1.next;
            }
            else{
                newnode.next=sl2;
                sl2=sl2.next;
            }
            newnode=newnode.next;            
        }
        if(sl1!=null){
           newnode.next=sl1;
        }
         if(sl2!=null){
            newnode.next=sl2;
        }
        return head.next;
    }
}

/*
Merge Two Sorted Lists

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
*/
