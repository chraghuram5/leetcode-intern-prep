class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[] answer=new int[m*n];
        int idx=0;
        for(int k=0;k<=(m+n-2);k++){
            if(k%2==0){
                int i=k;
                int j=0;
                while(i>=0 && j<=k){
                    if(i<m && j<n)
                        answer[idx++]=mat[i][j];
                    i--;
                    j++;
                }
            }
            else{
                int i=0;
                int j=k;
                while(j>=0 && i<=k){
                    if(i<m && j<n)
                        answer[idx++]=mat[i][j];
                    i++;
                    j--;
                }
            }
        }
        return answer;
    }
}