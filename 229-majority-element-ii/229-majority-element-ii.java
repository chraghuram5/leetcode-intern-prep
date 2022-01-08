class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();

        for(int i=0;i<nums.length;i++){
            Integer current=map.get(nums[i]);
            if(current!=null){
                map.put(nums[i],current+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        ArrayList<Integer> answerList=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])!=null && map.get(nums[i])>(nums.length/3)){
                answerList.add(nums[i]);
                map.put(nums[i], null);
            }
        }
        return answerList;
    }
}