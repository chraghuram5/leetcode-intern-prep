class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] A=nums;
        int B=target;
        int firstOccurence=-1;
        int lastOccurence=-1;
        int low=0;
        int high=A.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(A[mid]<B){
                low=mid+1;
            }
            else{
                firstOccurence=mid;
                high=mid-1;
            }
        }
        if(firstOccurence!=-1 && A[firstOccurence]!=B)
            firstOccurence=-1;
        low=0;
        high=A.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(A[mid]>B){
                high=mid-1;
            }
            else{
                lastOccurence=mid;
                low=mid+1;
            }
        }
        if(lastOccurence!=-1 && A[lastOccurence]!=B)
            lastOccurence=-1;
        int[] answer=new int[2];
        answer[0]=firstOccurence;
        answer[1]=lastOccurence;
        return answer;
    }
}