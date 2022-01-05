class Solution {
    public int[] plusOne(int[] digits) {
        int[] B = new int[digits.length];
        int carry=1;
        for(int i=digits.length-1;i>=0;i--){
            int sum=digits[i]+carry;
            B[i]=sum%10;
            carry=sum/10;
        }

        
        int[] answer=new int[B.length+1];
        answer[0]=carry;
        for(int i=1;i<answer.length;i++)
            answer[i]=B[i-1];
        int zeroes=0;
        for(int i=0;i<answer.length;i++){
            if(answer[i]==0)
                zeroes++;
            else
                break;
        }
        int[] finalAnswer = new int[answer.length-zeroes];
        for(int i=0;i<finalAnswer.length;i++)
            finalAnswer[i]=answer[i+zeroes];
        return finalAnswer;
    }
}