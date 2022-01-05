class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
        }
        if(sum%3!=0)
            return false;
        int[] prefix=new int[arr.length];
        int[] suffix=new int[arr.length];
        prefix[0]=arr[0];
        for(int i=1;i<arr.length;i++)
            prefix[i]=prefix[i-1]+arr[i];
        for(int i=arr.length-1;i>=0;i--){
            if(i>=arr.length-1)
                suffix[i]=arr[i];
            else
                suffix[i]=suffix[i+1]+arr[i];
        }
        int firstIndex=arr.length;
        for(int i=0;i<arr.length;i++){
            if(prefix[i]==sum/3){
                firstIndex=i;
                break;
            }
        }
        int lastIndex=0;
        for(int i=arr.length-1;i>=0;i--){
            if(suffix[i]==sum/3){
                lastIndex=i;
                break;
            }
        }
        if((lastIndex-firstIndex)>=2)
            return true;
        return false;
    }
}