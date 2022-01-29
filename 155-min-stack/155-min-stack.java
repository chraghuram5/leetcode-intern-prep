class MinStack {
    public static Stack<Long> s;
    public static Stack<Long> ss;
    public MinStack() {
        s=new Stack<Long>();
        ss=new Stack<Long>();
    }
    
    public void push(int val) {
        Long x=(long)val;
        s.push(x);
        if(!ss.isEmpty() && x<=ss.peek())
            ss.push(x);
        if(ss.isEmpty())
            ss.push(x);
    }
    
    public void pop() {
        if(s.isEmpty())
            return;
        if(!s.isEmpty()){
            if(!ss.isEmpty() && s.peek()==ss.peek())
                ss.pop();
            s.pop();
        }
    }
    
    public int top() {
        if(!s.isEmpty())
            return s.peek().intValue();
        return -1;
    }
    
    public int getMin() {
        if(s.isEmpty())
            return -1;
        if(!ss.isEmpty())
            return ss.peek().intValue();
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */