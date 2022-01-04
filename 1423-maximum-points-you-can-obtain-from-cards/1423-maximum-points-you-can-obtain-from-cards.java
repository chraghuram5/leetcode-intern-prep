class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int minSum=Integer.MAX_VALUE;
        int tempSum=0;
        for(int i=0;i<cardPoints.length-k;i++)
            tempSum=tempSum+cardPoints[i];
        minSum=Math.min(tempSum, minSum);
        int i=0;
        int j=cardPoints.length-k;
        while(i<=j && j<=cardPoints.length-1){
            tempSum=tempSum-cardPoints[i]+cardPoints[j];
            i++;
            j++;
            minSum=Math.min(tempSum, minSum);
        }
        int sum=0;
        for(int m=0;m<cardPoints.length;m++)
            sum=sum+cardPoints[m];
        return sum-minSum;
    }
}