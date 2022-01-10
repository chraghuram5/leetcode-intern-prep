class Solution {
    public static int rowSearch(int[][] A, int b){
        int low=0;
        int high=A.length-1;
        int answer=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(A[mid][0]==b)
                return mid;
            if(A[mid][0]<=b){
                answer=mid;
                low=mid+1;
            }
            if(A[mid][0]>b)
                high=mid-1;
        }
        return answer;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int[][] A=matrix;
        int B=target;
        int low=0;
        int high=(A.length*A[0].length)-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int x=mid/A[0].length;
            int y=mid%A[0].length;
            if(A[x][y]==B)
                return true;
            if(A[x][y]<B)
                low=mid+1;
            if(A[x][y]>B)
                high=mid-1;
        }
        return false;
    }
}