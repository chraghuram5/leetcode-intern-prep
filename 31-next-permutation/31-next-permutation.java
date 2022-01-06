class Solution {
    public static void reverse(int[] array){
        int n=array.length;
        for (int i=0;i<n/2;i++){
            int temp=array[i];
            array[i]=array[n-i-1];
            array[n-i-1]=temp;
        }
    }
    public void nextPermutation(int[] nums) {
        int index=-1;
        for(int i=nums.length-1;i>=1;i--){
            if(nums[i-1]<nums[i]){
                index=i-1;
                break;
            }
        }
        if(index==-1){
            Arrays.sort(nums);
        }
        else{
            int k=-1;
            for(int i=nums.length-1;i>=0;i--){
                if(nums[i]>nums[index]){
                    k=i;
                    break;
                }
            }
            int temp=nums[index];
            nums[index]=nums[k];
            nums[k]=temp;

            Arrays.sort(nums, index+1, nums.length);
        }
    }
}