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
    
    public static ListNode swap(ListNode head){
        //base and corner cases
        if(head==null || head.next==null)
            return head;
        
        //Assume swap method swaps the rest of the linkedlist and returns head
        ListNode swapped=swap(head.next.next);
        
        //swap first two and return second as head
        ListNode first=head;
        ListNode second=head.next;
        head.next=swapped;
        second.next=first;
        return second;
    }
    public ListNode swapPairs(ListNode head) {
        return swap(head);
    }
}