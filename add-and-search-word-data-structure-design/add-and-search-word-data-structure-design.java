class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode temp=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(temp.children[c-'a']==null)
                temp.children[c-'a']=new TrieNode();
            temp=temp.children[c-'a'];
        }
        temp.flag=true;
    }
    
    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }
    
    public boolean searchHelper(TrieNode root, String word, int idx) {
        if(idx==word.length())
            return root.flag;
        char c=word.charAt(idx);
        boolean answer=false;
        if(c=='.'){
            for(int i=0;i<26;i++){
                if(root.children[i]!=null)
                    answer=answer||searchHelper(root.children[i], word, idx+1);
            }
        }
        else{
            if(root.children[c-'a']==null)
                answer=answer||false;
            else
                answer=answer|| searchHelper(root.children[c-'a'], word, idx+1);  
        }      
        return answer;
    }
}
class TrieNode{
    TrieNode[] children;
    boolean flag;
    TrieNode(){
        flag=false;
        children=new TrieNode[26];
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */