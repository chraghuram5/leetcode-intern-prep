class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] answer=new int[nums.length-k+1];
        Deque<Integer> dq = new ArrayDeque<Integer>();
        for(int i=0;i<k;i++){
            if(dq.isEmpty())
                dq.addLast(i);
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i])
                dq.removeLast();
            dq.add(i);
        }
        int idx=0;
        answer[idx++]=nums[dq.getFirst()];
        for(int i=k;i<nums.length;i++){
            while(!dq.isEmpty() && !(dq.peekFirst()>(i-k)))
                dq.removeFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i])
                dq.removeLast();
            dq.add(i);
            answer[idx++]=nums[dq.getFirst()];
        }
        return answer;
    }
}