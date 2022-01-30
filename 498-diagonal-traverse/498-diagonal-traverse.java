class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[] answer=new int[m*n];
        int idx=0;
        for(int k=0;k<=(m+n-2);k++){
            if(k%2==0){
                int i=Math.min(k,m-1);
                int j=k-i;
                while(i>=0 && j<n){
                    answer[idx++]=mat[i][j];
                    i--;
                    j++;
                }
            }
            else{
                int j=Math.min(k,n-1);
                int i=k-j;
                while(j>=0 && i<m){
                    answer[idx++]=mat[i][j];
                    i++;
                    j--;
                }
            }
        }
        return answer;
    }
}