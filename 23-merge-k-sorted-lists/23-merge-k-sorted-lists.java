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
class ListNodeComparator implements Comparator<ListNode>{
    public int compare(ListNode listNode1, ListNode listNode2){
        if(listNode1.val<=listNode2.val)
            return -1;
        else
            return 1;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue=new PriorityQueue<ListNode>(new ListNodeComparator());
        ListNode dummy=new ListNode();
        ListNode head=dummy;
		for(int i=0;i<lists.length;i++){
            if(lists[i]!=null)
                queue.add(lists[i]);
        }
		while(!queue.isEmpty()){
			ListNode temp=queue.remove();
			head.next=temp;
            head=head.next;
			if(temp.next!=null)
				queue.add(temp.next);
		}
        head.next=null;
        return dummy.next;
    }
}