class Solution {
    public int titleToNumber(String columnTitle) {
        String A=columnTitle;
        int i=A.length()-1;
        int mul=26;
        int count=0;
        while(i>=0){
            if(i==(A.length()-1))
                count=count+(A.charAt(i)-'A'+1);
            else{
                count=count+(A.charAt(i)-'A'+1)*mul;
                mul=mul*26;
            }
            i--;
        }
        return count;
    }
}