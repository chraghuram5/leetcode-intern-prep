class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0 || nums[i]>nums.length)
                nums[i]=Integer.MAX_VALUE;
        }

        for(int i=0;i<nums.length;i++){
            int j=nums[i];
            if(j<0){
                j=j*-1;
                if(j!=Integer.MAX_VALUE && nums[j-1]>0)
                    nums[j-1]=nums[j-1]*-1;
            }
            else{
                if(j!=Integer.MAX_VALUE && nums[j-1]>0)
                    nums[j-1]=nums[j-1]*-1;
            }
        }
        for(int i=0;i<nums.length;i++)
            System.out.print(nums[i]+" ");
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                return i+1;
        }
        return nums.length+1;
    }
}