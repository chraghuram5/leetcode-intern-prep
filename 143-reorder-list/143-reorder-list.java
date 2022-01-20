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
    public static ListNode findMid(ListNode head){
        if(head==null)
            return head;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow.next;
        slow.next=null;
        return mid;
    }
    public static ListNode merge(ListNode h1, ListNode h2){
        ListNode head=new ListNode(-1);
        ListNode h=head;
        while(h1!=null && h2!=null){
            h.next=h1;
            h1=h1.next;
            h=h.next;
            h.next=h2;
            h2=h2.next;
            h=h.next;
        }
        if(h1!=null)
            h.next=h1;
        if(h2!=null)
            h.next=h2;
        h=head.next;
        return head.next;
    }
    public static ListNode reverse(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode tail=head.next;
        head.next=null;
        ListNode reversedHead=reverse(tail);
        tail.next=head;
        return reversedHead;
        
    }
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
            return;
        ListNode mid=findMid(head);
        ListNode h1=head;
        ListNode h2=reverse(mid);
        head=merge(h1,h2);
    }
}