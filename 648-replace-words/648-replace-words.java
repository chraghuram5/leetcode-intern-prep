class TrieNode{
    TrieNode[] children;
    boolean flag;
    TrieNode(){
        flag=false;
        children=new TrieNode[26];
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root=new TrieNode();
    }
    
    public void insert(String word) {
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
        TrieNode temp=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(temp.children[c-'a']==null)
                return false;
            temp=temp.children[c-'a'];
        }
        return temp.flag;
    }
    
    public String searchRoot(String word) {
        TrieNode temp=root;
        String answer="";
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(temp.flag)
                return answer;
            answer=answer+c;
            if(temp.children[c-'a']==null)
                return "";
            temp=temp.children[c-'a'];
        }
        return answer;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode temp=root;
        for(int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            if(temp.children[c-'a']==null)
                return false;
            temp=temp.children[c-'a'];
        }
        return true;
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie=new Trie();
        for(String root: dictionary)
            trie.insert(root);
        String answer="";
        String[] words=sentence.split(" ");
        for(String word: words){
            if(trie.searchRoot(word).equals(""))
                answer=answer+word+" ";
            else
                answer=answer+trie.searchRoot(word)+" ";
        }
        return answer.trim();
    }
}