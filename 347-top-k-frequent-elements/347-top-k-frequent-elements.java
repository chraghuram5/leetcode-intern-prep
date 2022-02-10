class Helper implements Comparable<Helper>{
    int first;
    int second;
    public Helper(int first, int second){
        this.first=first;
        this.second=second;
    }
    public int compareTo(Helper d){
        if(this.first<=d.first)
            return -1;
        else
            return 1;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> fMap=new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            if(fMap.get(nums[i])==null)
                fMap.put(nums[i], 1);
            else
                fMap.put(nums[i], fMap.get(nums[i])+1);
        }
        //System.out.println(fMap);
        PriorityQueue<Helper> q=new PriorityQueue<>();
        for(Map.Entry<Integer, Integer> e:fMap.entrySet()){
            if(q.size()<k)
                q.add(new Helper(e.getValue(),e.getKey()));
            else{
                q.add(new Helper(e.getValue(),e.getKey()));
                q.remove();
            }
            //System.out.println(q);
        }
        
        int[] topK=new int[k];
        int z=0;
        while(!q.isEmpty())
            topK[z++]=q.remove().second;
        return topK;
    }
}