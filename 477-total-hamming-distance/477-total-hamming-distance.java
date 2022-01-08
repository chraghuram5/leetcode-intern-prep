class Solution {
    public int totalHammingDistance(int[] nums) {
        int count=0;
        for(int i=0;i<=31;i++){
            int zeroCount=0;
            int oneCount=0;
            for(int j=0;j<nums.length;j++){
                if((nums[j]&(1<<i))==0)
                    zeroCount++;
                else
                    oneCount++;
            }
            count=count+(zeroCount*oneCount);
        }
        return count;
    }
}