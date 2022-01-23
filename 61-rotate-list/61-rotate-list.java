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
    public static int size(ListNode h){
        if(h==null)
            return 0;
        if(h.next==null)
            return 1;
        int count=1;
        while(h!=null && h.next!=null){
            h=h.next;
            count++;
        }
        return count;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)
            return head;
        int length=size(head);
        System.out.println(length);
        k=k%length;
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode slow=dummyHead;
        ListNode fast=dummyHead;
        while(fast!=null && fast.next!=null && k>0){
            fast=fast.next;
            k--;
        }
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        
        fast.next=dummyHead.next;
        dummyHead.next=slow.next;
        slow.next=null;
        return dummyHead.next;
        
    }
}