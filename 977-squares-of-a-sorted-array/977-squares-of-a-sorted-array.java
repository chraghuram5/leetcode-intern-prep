class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] answer = new int[nums.length];
        int i=0;
        int j=nums.length-1;
        int k=nums.length-1;
        while(i<=j){
            if(nums[i]*nums[i]>=nums[j]*nums[j]){
                answer[k--]=nums[i]*nums[i];
                i++;
            }
            else{
                answer[k--]=nums[j]*nums[j];
                j--;
            }
        }
        return answer;
    }
}