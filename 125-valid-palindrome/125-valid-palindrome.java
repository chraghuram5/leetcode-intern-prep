class Solution {
    public boolean isPalindrome(String s) {
        HashSet<Character> set=new HashSet<Character>();
        for(char c='a';c<='z';c++)
            set.add(c);
        for(char c='0';c<='9';c++)
            set.add(c);
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            Character first=Character.toLowerCase(s.charAt(i));
            Character last=Character.toLowerCase(s.charAt(j));
            if(!set.contains(first))
                i++;
            else if(!set.contains(last))
                j--;
            else if(first!=last)
                return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }
}