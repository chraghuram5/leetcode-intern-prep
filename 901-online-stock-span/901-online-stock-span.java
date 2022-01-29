class StockSpanner {
    public static HashMap<Integer, Integer> map;
    public static Stack<Integer> stack;
    public static int currentIndex;
    public StockSpanner() {
        map=new HashMap<Integer, Integer>();
        stack=new Stack<Integer>();
        currentIndex=0;
    }
    
    public int next(int price) {
        map.put(price, currentIndex);
        currentIndex++;
        while(!stack.isEmpty() && stack.peek()<=price)
            stack.pop();
        if(!stack.isEmpty()){
            Integer top=stack.peek();
            stack.push(price);
            return currentIndex-map.get(top)-1;
        }
        else{
            stack.push(price);
            return currentIndex;
        }       
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */