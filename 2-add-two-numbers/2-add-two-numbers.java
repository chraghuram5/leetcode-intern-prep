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
    public static ListNode reverse(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode tail=head.next;
        head.next=null;
        ListNode reversedHead=reverse(tail);
        tail.next=head;
        return reversedHead;
        
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // l1=reverse(l1);
        // l2=reverse(l2);
        ListNode head=new ListNode(-1);
        ListNode dummyHead=head;
        int carry=0;
        while(l1!=null && l2!=null){
            int currentSum=l1.val+l2.val+carry;
            ListNode current=new ListNode(currentSum%10);
            carry=currentSum/10;
            head.next=current;
            head=head.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int currentSum=l1.val+carry;
            ListNode current=new ListNode(currentSum%10);
            carry=currentSum/10;
            head.next=current;
            head=head.next;
            l1=l1.next;
        }
        while(l2!=null){
            int currentSum=l2.val+carry;
            ListNode current=new ListNode(currentSum%10);
            carry=currentSum/10;
            head.next=current;
            head=head.next;
            l2=l2.next;
        }
        if(carry!=0){
            ListNode current=new ListNode(carry);
            head.next=current;
            head=head.next;
        }
        head.next=null;
        return dummyHead.next;
    }
}