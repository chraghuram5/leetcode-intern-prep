class ListNode{
    ListNode prev;
    ListNode next;
    int key;
    int value;
    ListNode(int key, int value){
        this.key=key;
        prev=null;
        next=null;
        this.value=value;
    }
}
class LRUCache {
    public static HashMap<Integer, ListNode> map;
    public static ListNode head;
    public static ListNode tail;
    public static int capacity;
    public static int currentSize;
    public LRUCache(int capacity) {
        map=new HashMap<Integer, ListNode>();
        head=new ListNode(-1, -1);
        tail=new ListNode(-1, -1);
        head.next=tail;
        tail.prev=head;
        this.capacity=capacity;
        currentSize=0;
    }
    public static void move(ListNode currentNode){
        ListNode temp=currentNode.next;
        temp.prev=currentNode.prev;
        currentNode.prev.next=temp;
        currentNode.next=head.next;
        currentNode.next.prev=currentNode;
        head.next=currentNode;
        currentNode.prev=head;
    }
    public static void insert(ListNode newNode){
        head.next.prev=newNode;
        newNode.next=head.next;
        newNode.prev=head;
        head.next=newNode;
    }
    public static void remove(){
        tail.prev.prev.next=tail;
        tail.prev=tail.prev.prev;
    }
    public int get(int key) {
        if(map.get(key)==null)
            return -1;
        ListNode currentNode = map.get(key);
        move(currentNode);
        return currentNode.value;
    }
    
    public void put(int key, int value) {
        if(map.get(key)!=null){
            ListNode currentNode=map.get(key);
            currentNode.value=value;
            move(currentNode);
        }
        else{
            ListNode newNode=new ListNode(key, value);
            if(currentSize<capacity){
                //map.put(key, newNode);
                currentSize++;
            }
            else{
                map.remove(tail.prev.key);
                remove();
            }
            insert(newNode);
            map.put(key, newNode);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */