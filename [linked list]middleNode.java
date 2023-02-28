class Solution {
    public ListNode middleNode(ListNode head) {
        int length = 0;

        ListNode aux = head;

        while(aux!=null){
            length++;
            aux = aux.next;
        }

        aux = head;
        length = length/2;

        while(length>0){
            length--;
            aux = aux.next;
        }

        return aux;
    }
}

/*
876. Middle of the Linked List

Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
*/
