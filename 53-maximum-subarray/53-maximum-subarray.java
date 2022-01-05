class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int answer = Integer.MIN_VALUE;
        int i=0;
        while(i<nums.length){
            if(sum<0)
                sum=0;
            sum=sum+nums[i];
            answer=Math.max(answer,sum);
            i++;
        }
        return answer;
    }
}