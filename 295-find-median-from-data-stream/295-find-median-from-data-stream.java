class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    int count;
    public MedianFinder() {
        minHeap=new PriorityQueue<Integer>();
        maxHeap=new PriorityQueue<Integer>(Collections.reverseOrder());
        count=0;
    }
    
    public void addNum(int num) {
        minHeap.add(num);
        count++;
        if(count%2==1){
            int k=count/2+1;
            if(maxHeap.size()<k)
                maxHeap.add(minHeap.remove());
            else{
                maxHeap.add(minHeap.remove());
                minHeap.add(maxHeap.remove());
            }
        }
        else{
            int k=count/2+1;
            if(maxHeap.size()<k)
                maxHeap.add(minHeap.remove());
            else{
                maxHeap.add(minHeap.remove());
                minHeap.add(maxHeap.remove());
            }
        }
    }
    
    public double findMedian() {
        if(count==0)
            return 0.0;
        if(count%2==1){
            int temp=maxHeap.peek();
            return (double)temp;
        }
        else{
            int first=maxHeap.remove();
            int second=maxHeap.peek();
            maxHeap.add(first);
            return ((double)first+(double)second)/2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */