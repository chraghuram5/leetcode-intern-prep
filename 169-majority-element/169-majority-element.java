class Solution {
    public int majorityElement(int[] nums) {
        int answer=0;
        for(int i=0;i<32;i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                if(((1<<i)&nums[j])!=0)
                    count++;
            }
            if(count>nums.length/2)
                answer=answer+(1<<i);
        }
        return answer;
    }
}