class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()==1)
            return "";
        String answer=palindrome;
        for(int i=0;i<palindrome.length();i++){
            if(palindrome.charAt(i)!='a'){
                if(palindrome.length()%2==1 && i==palindrome.length()/2)
                    continue;
                answer=palindrome.substring(0,i)+'a'+palindrome.substring(i+1,palindrome.length());
                break;
            }
        }
        if(palindrome.equals(answer))
            answer=answer.substring(0, answer.length()-1)+'b';
        return answer;
    }
}