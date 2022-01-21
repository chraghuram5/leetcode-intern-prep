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
    public ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode head=A;
        int left=B;
        int right=C;
        if(head==null || head.next==null)
            return head;
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode firstPrev=dummyHead;
        ListNode firstCurr=head;
        int firstPosition=1;
        while(firstCurr!=null){
            if(firstPosition==left){
                break;
            }
            firstPrev=firstCurr;
            firstCurr=firstCurr.next;
            firstPosition++;
        }
        
        ListNode secondCurr=dummyHead;
        int secondPosition=0;
        while(secondCurr!=null){
            if(secondPosition==right)
                break;
            secondCurr=secondCurr.next;
            secondPosition++;
        }
        if(firstCurr!=null && secondCurr!=null){
            ListNode temp=secondCurr.next;
            secondCurr.next=null;
            firstPrev.next=reverse(firstCurr);
            firstCurr.next=temp;
        }
        return dummyHead.next;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null)
            return head;
        int count=0;
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode h=dummyHead;
        while(h!=null){
            count++;
            h=h.next;
        }
        
        for(int i=1;i<=count;i=i+k){
            dummyHead.next=reverseBetween(dummyHead.next, i, i+k-1);
        }
        return dummyHead.next;
    }
}