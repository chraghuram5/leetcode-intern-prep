class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c==']' || c==')' || c=='}'){
                if(stack.isEmpty())
                    return false;
                char p=stack.pop();
                if(c==']' && p!='[')
                    return false;
                if(c==')' && p!='(')
                    return false;
                if(c=='}' && p!='{')
                    return false;
            }
            else
                stack.push(c);
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
}