/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==head)
            return head;
        if(head.next==null)
            return null;
        ListNode s=head.next;
        ListNode f=head.next.next;
        while(f!=null && f.next!=null && f!=s){
            s=s.next;
            f=f.next.next;
        }
        
        if(f==null || f.next==null)
            return null;
        s=head;
        while(s!=f){
            s=s.next;
            f=f.next;
        }
        return s;
        
    }
}