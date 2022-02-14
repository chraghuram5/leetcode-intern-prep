class TrieNode{
    TrieNode[] children;
    TrieNode(){
        children=new TrieNode[2];
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root=new TrieNode();
    }
    
    public void insert(int n) {
        TrieNode temp=root;
        for(int i=31;i>=0;i--){
            int x=0;
            if(((1<<i)&n)!=0)
                x=1;
            if(temp.children[x]==null)
                temp.children[x]=new TrieNode();
            temp=temp.children[x];       
        }
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie=new Trie();
        int max=0;
        for(int i=0;i<nums.length;i++)
            trie.insert(nums[i]);
        for(int j=0;j<nums.length;j++){
            int num=nums[j];
            //trie.insert(num);
            int current=0;
            TrieNode root=trie.root;
            for(int i=31;i>=0;i--){
                int requiredBit=0;
                if(((1<<i)&num)==0)
                    requiredBit=1;
                if(root.children[requiredBit]!=null){
                    current=current+(1<<i);
                    root=root.children[requiredBit];
                }
                else
                    root=root.children[1-requiredBit];
                    
            }
            max=Math.max(max, current);
        }
        return max;
    }
}