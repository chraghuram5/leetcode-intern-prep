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
        //System.out.println("mid value:"+mid.val);
        return mid;
    }
    public static ListNode merge(ListNode h1, ListNode h2){
        //System.out.println("called merge");
        ListNode head=new ListNode(-1);
        ListNode h=head;
        while(h1!=null && h2!=null){
            if(h1.val<=h2.val){
                h.next=h1;
                h1=h1.next;
                h=h.next;
                h.next=null;
            }
            else{
                h.next=h2;
                h2=h2.next;
                h=h.next;
                h.next=null;
            }
        }
        if(h1!=null)
            h.next=h1;
        if(h2!=null)
            h.next=h2;
        h=head.next;
        //System.out.println("printing nodes");
        // while(h!=null){
        //     System.out.print(h.val);
        //     h=h.next;
        // }
        // System.out.println();
        return head.next;
    }
    public static ListNode sort(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode mid=findMid(head);
        ListNode h1=sort(head);
        ListNode h2=sort(mid);
        return merge(h1,h2);
    }
    public ListNode sortList(ListNode head) {
        return sort(head);
    }
}