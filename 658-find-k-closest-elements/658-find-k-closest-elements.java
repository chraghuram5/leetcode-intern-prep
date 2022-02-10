class Difference implements Comparable<Difference>{
    int diff;
    int value;
    public Difference(int diff, int value){
        this.diff=diff;
        this.value=value;
    }
    public int compareTo(Difference d){
        if(this.diff< d.diff)
            return -1;
        else if(this.diff==d.diff){
            if(this.value<=d.value)
                return -1;
        }
        return 1;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Difference> q=new PriorityQueue<Difference>(Collections.reverseOrder());
        for(int i=0;i<k && i<arr.length;i++){
            q.add(new Difference(Math.abs(x-arr[i]), arr[i]));
        }
        for(int i=k;i<arr.length;i++){
            Difference d=q.peek();
            if(Math.abs(arr[i]-x)<d.diff){
                q.remove();
                q.add(new Difference(Math.abs(x-arr[i]), arr[i]));
            }
            else if(Math.abs(arr[i]-x)==d.diff){
                if(arr[i]<=d.value){
                    q.remove();
                    q.add(new Difference(Math.abs(x-arr[i]), arr[i]));
                }
            }
        }
        List<Integer> answer=new ArrayList<Integer>();
        while(!q.isEmpty())
            answer.add(q.remove().value);
        Collections.sort(answer);
        return answer;
    }
}