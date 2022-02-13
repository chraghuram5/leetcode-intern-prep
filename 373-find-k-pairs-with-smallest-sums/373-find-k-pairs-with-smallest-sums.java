class Pair implements Comparable<Pair>{
	int value;
	int first;
	int second;
	public Pair(int value, int first, int second){
		this.value=value;
		this.first=first;
		this.second=second;
	}
	public int compareTo(Pair pair){
		if(this.value<=pair.value)
			return -1;
		else
			return 1;
	}
	public String toString(){
		return this.value+" "+this.first+" "+this.second;
	}
}
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> queue=new PriorityQueue<Pair>();
		for(int i=0;i<nums1.length;i++)
			queue.add(new Pair(nums1[i]+nums2[0], i, 0));
        List<List<Integer>> answer=new ArrayList<List<Integer>>();
		while(!queue.isEmpty() && answer.size()<k){
			Pair pair=queue.remove();
            ArrayList<Integer> temp=new ArrayList<Integer>();
            temp.add(nums1[pair.first]);
            temp.add(nums2[pair.second]);
			answer.add(temp);
			int index=pair.second+1;
			int first=pair.first;
			if((index)<nums2.length)
				queue.add(new Pair(nums1[pair.first]+nums2[index], pair.first, index));
		}
        return answer;
    }
}