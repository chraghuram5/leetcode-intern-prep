class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int B=target;
        HashSet<String> set=new HashSet<>();
        ArrayList<List<Integer>> answer=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                int sum=B-nums[i]-nums[j];
                int m=j+1;
                int n=nums.length-1;
                while(m<n && m<(nums.length-1)){
                    if((nums[m]+nums[n])==sum){
                        ArrayList<Integer> temp=new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[m]);
                        temp.add(nums[n]);
                        if(!set.contains(nums[i]+""+nums[j]+""+nums[m]+""+nums[n]+""))
                            answer.add(temp);
                        set.add(nums[i]+""+nums[j]+""+nums[m]+""+nums[n]+"");
                        m++;
                        n--;
                        //break;
                    }
                    else if((nums[m]+nums[n])<sum)
                        m++;
                    else
                        n--;
                }
            }
        }
        return answer;
    }
}