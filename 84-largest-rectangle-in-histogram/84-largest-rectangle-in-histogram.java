class StackObject{
    int value;
    int index;
    StackObject(){}
    StackObject(int value, int index){
        this.value=value;
        this.index=index;
    }
}
class Solution {
    public static int[] nsr(int[] heights){
        int[] answer=new int[heights.length];
        Stack<StackObject> stack=new Stack<StackObject>();
        for(int i=heights.length-1;i>=0;i--){
            int current=heights[i];
            while(!stack.isEmpty() && current<=stack.peek().value)
                stack.pop();
            if(stack.isEmpty())
                answer[i]=heights.length;
            else
                answer[i]=stack.peek().index;
            stack.push(new StackObject(current,i));
        }
        return answer;
    }
    public static int[] nsl(int[] heights){
        int[] answer=new int[heights.length];
        Stack<StackObject> stack=new Stack<StackObject>();
        for(int i=0;i<heights.length;i++){
            int current=heights[i];
            while(!stack.isEmpty() && current<=stack.peek().value)
                stack.pop();
            if(stack.isEmpty())
                answer[i]=-1;
            else
                answer[i]=stack.peek().index;
            stack.push(new StackObject(current,i));
        }
        return answer;
    }
    public int largestRectangleArea(int[] heights) {
        int[] nsl=nsl(heights);
        int[] nsr=nsr(heights);
        for(int i=0;i<nsl.length;i++)
            System.out.print(nsl[i]+" ");
        System.out.println();
        for(int i=0;i<nsr.length;i++)
            System.out.print(nsr[i]+" ");
        System.out.println();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++)
            max=Math.max(max, (nsr[i]-nsl[i]-1)*heights[i]);
        return max;
    }
}