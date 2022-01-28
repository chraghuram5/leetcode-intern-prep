class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s=new Stack<Integer>();
        int[] nextGreater=new int[nums2.length];
        for(int i=nums2.length-1;i>=0;i--){
            //pop element from stack as long as it is less than the current element
            while(!s.isEmpty() && nums2[i]>=s.peek())
                s.pop();
            //Handle stack empty
            if(s.isEmpty())
                nextGreater[i]=-1;
            else
                nextGreater[i]=s.peek();
            s.push(nums2[i]);
        }
        int[] answer=new int[nums1.length];
        //HashMap for storing elements of nums2 for searching in an instant
        HashMap<Integer, Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums2.length;i++)
            map.put(nums2[i],i);
        //check for index of nums1 in nums2 using map and get the answer
        for(int i=0;i<nums1.length;i++){
            answer[i]=nextGreater[map.get(nums1[i])];
        }
        return answer;
    }
}