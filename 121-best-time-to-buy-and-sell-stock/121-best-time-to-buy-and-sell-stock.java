class Solution {
    public int maxProfit(int[] prices) {
        int[] prefix=new int[prices.length];
        prefix[0]=prices[0];
        for(int i=1;i<prices.length;i++)
            prefix[i]=Math.min(prefix[i-1], prices[i]);
        int[] suffix=new int[prices.length];
        suffix[prices.length-1]=prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--)
            suffix[i]=Math.max(suffix[i+1], prices[i]);
        for(int i=0;i<prices.length;i++){
            System.out.print(prefix[i]+" ");
        }
        System.out.println();
        for(int i=0;i<prices.length;i++){
            System.out.print(suffix[i]+" ");
        }
        int max=0;
        for(int i=0;i<prices.length;i++)
            max=Math.max(max, suffix[i]-prefix[i]);
        return max;
    }
}