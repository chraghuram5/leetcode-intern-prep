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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || (head.next==null && n==1))
            return null;
        if(n==0)
            return head;
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode slow=dummyHead;
        ListNode fast=dummyHead;
        while(fast!=null && fast.next!=null && n>0){
            fast=fast.next;
            n--;
        }
        
        //size of LinkedList less than n
        if(n!=0)
            return dummyHead.next;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        
        slow.next=slow.next.next;
        
        return dummyHead.next;
        
    }
}