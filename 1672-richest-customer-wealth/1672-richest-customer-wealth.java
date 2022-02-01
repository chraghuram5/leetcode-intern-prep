class Solution {
    public int maximumWealth(int[][] accounts) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<accounts.length;i++){
            int amount=0;
            for(int j=0;j<accounts[0].length;j++)
                amount=amount+accounts[i][j];
            max=Math.max(max, amount);
        }
        return max;
    }
}