public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode dummy = head;
        while(!set.contains(dummy) && dummy!=null){
            set.add(dummy);
            dummy = dummy.next;
        }
        return dummy;
    }
}
