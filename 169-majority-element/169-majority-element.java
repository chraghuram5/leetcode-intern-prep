class Solution {
    public int majorityElement(int[] nums) {
        int current=-1;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                current=nums[i];
                count=1;
            }
            else{
                if(current==nums[i])
                    count++;
                else
                    count--;
            }
        }
        return current;
    }
}