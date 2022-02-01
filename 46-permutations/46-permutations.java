import java.util.Collections;
class Solution {
    public static int[] nextPermutation(int[] nums){
        int idx=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx=i;
                break;
            }
        }
        
        if(idx==-1){
            Arrays.sort(nums);
            return nums;
        }
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>nums[idx]){
                int temp=nums[i];
                nums[i]=nums[idx];
                nums[idx]=temp;
                break;
            }
        }
        Arrays.sort(nums, idx+1, nums.length);
        return nums;
    }
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        int[] a=new int[nums.length];
        for(int i=0;i<nums.length;i++)
                a[i]=nums[i];
        nums=nextPermutation(nums);
        System.out.print(nums);
        while(!Arrays.equals(nums,a)){
            for(int i=0;i<nums.length;i++)
                System.out.print(nums[i]+" ");
            System.out.println();
            Integer[] x=new Integer[nums.length];
            for(int i=0;i<nums.length;i++)
                x[i]=nums[i];
            ArrayList<Integer> temp=new ArrayList<Integer>();
            Collections.addAll(temp, x);
            list.add(temp);
            nums=nextPermutation(nums);
        }
        Integer[] x=new Integer[nums.length];
        for(int i=0;i<nums.length;i++)
            x[i]=nums[i];
        ArrayList<Integer> temp=new ArrayList<Integer>();
        Collections.addAll(temp, x);
        list.add(temp);
        return list;
    }
}