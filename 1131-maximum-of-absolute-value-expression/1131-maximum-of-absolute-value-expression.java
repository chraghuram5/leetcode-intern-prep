class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int answer=Integer.MIN_VALUE;
        int[] diffArray=new int[arr1.length];
        for(int i=0;i<arr1.length;i++)
            diffArray[i]=arr1[i]+arr2[i]-i;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr1.length;i++){
            max=Math.max(diffArray[i], max);
            min=Math.min(diffArray[i], min);
        }
        answer=Math.max(answer, max-min);
        for(int i=0;i<arr1.length;i++)
            diffArray[i]=arr1[i]+arr2[i]+i;
        max=Integer.MIN_VALUE;
        min=Integer.MAX_VALUE;
        for(int i=0;i<arr1.length;i++){
            max=Math.max(diffArray[i], max);
            min=Math.min(diffArray[i], min);
        }
        answer=Math.max(answer, max-min);
        for(int i=0;i<arr1.length;i++)
            diffArray[i]=arr1[i]-arr2[i]+i;
        max=Integer.MIN_VALUE;
        min=Integer.MAX_VALUE;
        for(int i=0;i<arr1.length;i++){
            max=Math.max(diffArray[i], max);
            min=Math.min(diffArray[i], min);
        }
        answer=Math.max(answer, max-min);
        for(int i=0;i<arr1.length;i++)
            diffArray[i]=arr1[i]-arr2[i]+i;
        max=Integer.MIN_VALUE;
        min=Integer.MAX_VALUE;
        for(int i=0;i<arr1.length;i++){
            max=Math.max(diffArray[i], max);
            min=Math.min(diffArray[i], min);
        }
        answer=Math.max(answer, max-min);
        for(int i=0;i<arr1.length;i++)
            diffArray[i]=-arr1[i]+arr2[i]+i;
        max=Integer.MIN_VALUE;
        min=Integer.MAX_VALUE;
        for(int i=0;i<arr1.length;i++){
            max=Math.max(diffArray[i], max);
            min=Math.min(diffArray[i], min);
        }
        answer=Math.max(answer, max-min);
        for(int i=0;i<arr1.length;i++)
            diffArray[i]=-arr1[i]+arr2[i]+i;
        max=Integer.MIN_VALUE;
        min=Integer.MAX_VALUE;
        for(int i=0;i<arr1.length;i++){
            max=Math.max(diffArray[i], max);
            min=Math.min(diffArray[i], min);
        }
        answer=Math.max(answer, max-min);
        return answer;
    }
}