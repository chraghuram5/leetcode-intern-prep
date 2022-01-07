class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int temp=Math.abs(nums[i]);
            int newTemp=nums[temp];
            if(newTemp<0)
                return temp;
            else
                nums[temp]=-1*nums[temp];
        }
        return -1;
    }
}