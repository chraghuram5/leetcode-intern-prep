class Solution {
    public String simplifyPath(String path) {
        String[] splitString=path.split("/");
        Stack<String> stack=new Stack<String>();
        for(String s:splitString){
            if(!s.equals("") && !s.equals(" ")){
                if(s.equals("..")){
                    if(!stack.isEmpty())
                        stack.pop();
                }
                else if(!s.equals("."))
                    stack.push(s);
            }
        }
        String answer="";
        while(!stack.isEmpty()){
            if(!stack.peek().equals(" ") && !stack.peek().equals(""))
                answer="/"+stack.pop()+answer;
        }
        if(answer.equals(""))
            answer='/'+answer;
        return answer;
    }
}