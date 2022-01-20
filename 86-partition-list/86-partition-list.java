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
    public ListNode partition(ListNode head, int x) {
        ListNode h1=new ListNode(-1);
        ListNode h2=new ListNode(-1);
        ListNode h=head;
        ListNode tempH1=h1;
        ListNode tempH2=h2;
        while(h!=null){
            if(h.val<x){
                tempH1.next=h;
                h=h.next;
                tempH1=tempH1.next;
                tempH1.next=null;
            }
            else{
                tempH2.next=h;
                h=h.next;
                tempH2=tempH2.next;
                tempH2.next=null;
            }
        }
        tempH1.next=h2.next;
        return h1.next;
    }
}