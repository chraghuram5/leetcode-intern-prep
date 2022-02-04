class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack=new Stack<Integer>();
        Character c[]=new Character[s.length()];
        for(int i=0;i<s.length();i++){
            Character current=s.charAt(i);
            if(current==')'){
                if(!stack.isEmpty() && s.charAt(stack.peek())=='(')
                    stack.pop();
                else
                    stack.push(i);
            }
            else if(current=='(')
                stack.push(i);
            c[i]=current;
        }
        
        while(!stack.isEmpty()){
            c[stack.pop()]='?';
        }
        
        String answer="";
        for(int i=0;i<c.length;i++){
            if(c[i]!='?')
                answer=answer+c[i];
        }
        return answer;
    }
}