class Solution {
    public int searchInsert(int[] nums, int target) {
        int b=target;
        int answer=0;
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==b){
                answer=mid;
                return answer;
            }
            if(nums[mid]>b){
                answer=mid;
                high=mid-1;
            }
            if(nums[mid]<b){
               low=mid+1;
            }
        }

        if(answer==0 && b>(nums[nums.length-1]))
            answer=nums.length;
        return answer;
    }
}