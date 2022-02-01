class Solution {
    public static List<List<Integer>> helper(int[] nums, int i){
        if(i==nums.length-1){
            List<Integer> list=new ArrayList<Integer>();
            list.add(nums[i]);
            ArrayList<List<Integer>> tempList=new ArrayList<List<Integer>>();
            tempList.add(list);
            return tempList;
        }
        List<List<Integer>> nextPerm=helper(nums, i+1);
        List<List<Integer>> newPerm=new ArrayList<List<Integer>>();
        int size=nextPerm.get(0).size();
        for(int j=0;j<=size;j++){
            for(List<Integer> temp:nextPerm){
                List<Integer> x=new ArrayList<>(temp);
                x.add(j, nums[i]);
                newPerm.add(x);
            }
        }
        return newPerm;
    }
    public List<List<Integer>> permute(int[] nums) {
        return helper(nums, 0);
    }
}