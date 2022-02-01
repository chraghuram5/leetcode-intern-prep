class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map=new HashMap<Character, String>();
        HashMap<String, Character> charMap=new HashMap<String, Character>();
        String[] words=s.split(" ");
        if(pattern.length()!=words.length)
            return false;
        for(int i=0;i<pattern.length();i++){
            if(map.get(pattern.charAt(i))==null && charMap.get(words[i])==null){
                map.put(pattern.charAt(i),words[i]);
                charMap.put(words[i], pattern.charAt(i));
            }
            else{
                if(!words[i].equals(map.get(pattern.charAt(i))) || !charMap.get(words[i]).equals(pattern.charAt(i))){
                    System.out.println(map);
                    System.out.println(charMap);
                    return false;   
                }
            }
        }
        return true;
    }
}