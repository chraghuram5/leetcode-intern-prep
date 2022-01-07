class Solution {
    public int findUnsortedSubarray(int[] nums) {
        ArrayList<Integer> prefix=new ArrayList<Integer>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(nums[i],max);
            prefix.add(max);
        }
        ArrayList<Integer> suffix=new ArrayList<Integer>();
        int min=Integer.MAX_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            min=Math.min(nums[i],min);
            suffix.add(0,min);
        }
        
        int right=-1;
        int left=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=suffix.get(i)){
                left=i;
                break;
            }
        }
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]!=prefix.get(i)){
                right=i;
                break;
            }
        }
        if(left==-1 && right==-1){
            return 0;
        }
        else{
            return right-left+1;
        }
    }
}