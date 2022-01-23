class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            Character c=s.charAt(i);
            if(c=='(' || c=='{' || c=='[')
                stack.push(c);
            if(stack.isEmpty())
                return false;
            if(c==')' || c=='}' || c==']'){
                if(c==')'){
                    if(stack.peek()!='(')
                        return false;
                    else
                        stack.pop();
                }
                if(c==']'){
                    if(stack.peek()!='[')
                        return false;
                    else
                        stack.pop();
                }
                if(c=='}'){
                    if(stack.peek()!='{')
                        return false;
                    else
                        stack.pop();
                }
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
}