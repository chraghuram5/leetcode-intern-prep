class Solution {
    public int mySqrt(int x) {
        int A=x;
        if(A==0)
            return 0;
        if(A==1)
            return 1;
        long low=0L;
        long high=(long)(A/2);
        long answer=0L;
        while(low<=high){
            long mid=low+(high-low)/2;
            if((mid*mid)<=A){
                answer=mid;
                low=mid+1;
            }
            else
                high=mid-1;
        }
        return (int)answer;
    }
}