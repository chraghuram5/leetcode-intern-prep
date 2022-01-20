/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null)
            return head;
        if(head.next==null)
            return head;
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode h=head.next;
        head.next=null;
        while(h!=null){
            ListNode prev=dummyHead;
            ListNode curr=dummyHead.next;
            while(curr!=null && curr.val < h.val){
                prev=curr;
                curr=curr.next;
            }
            if(curr==null){
                prev.next=h;
                h=h.next;
                prev.next.next=null;
            }
            else{
                prev.next=h;
                h=h.next;
                prev.next.next=curr;
            }
        }
        return dummyHead.next;
    }
}