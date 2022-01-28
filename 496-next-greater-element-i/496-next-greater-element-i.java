class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s=new Stack<Integer>();
        int[] nextGreater=new int[nums2.length];
        for(int i=nums2.length-1;i>=0;i--){
            while(!s.isEmpty() && nums2[i]>=s.peek())
                s.pop();
            if(s.isEmpty())
                nextGreater[i]=-1;
            else
                nextGreater[i]=s.peek();
            s.push(nums2[i]);
        }
        int[] answer=new int[nums1.length];
        HashMap<Integer, Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums2.length;i++)
            map.put(nums2[i],i);
        for(int i=0;i<nums1.length;i++){
            answer[i]=nextGreater[map.get(nums1[i])];
        }
        return answer;
    }
}