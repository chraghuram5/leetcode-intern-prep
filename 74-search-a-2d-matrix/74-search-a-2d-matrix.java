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
        int row=rowSearch(A, B);
        int low=0;
        int high=A[row].length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(A[row][mid]==B)
                return true;
            if(A[row][mid]<=B)
                low=mid+1;
            if(A[row][mid]>B)
                high=mid-1;
        }
        return false;
    }
}