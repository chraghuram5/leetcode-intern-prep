class Solution {
    public List<Integer> getRow(int rowIndex) {
        int A=rowIndex;
        Long[] pascalK=new Long[A+1];
        pascalK[0]=1L;
        pascalK[A]=1L;
        for(int i=1;i<=A/2;i++){
            pascalK[i]=pascalK[i-1]*(A-i+1L)/i;
            pascalK[A-i]=pascalK[i];
        }
        
        List<Integer> answer = new ArrayList<Integer>();
        for(int i=0;i<pascalK.length;i++)
            answer.add(pascalK[i].intValue());
        return answer;
    }
}