class Solution {
    public static String sort(String s){
        int[] count=new int[26];
        for(int i=0;i<s.length();i++)
            count[s.charAt(i)-'a']++;
        String answer="";
        for(int i=0;i<26;i++){
            while(count[i]>0){
                answer=answer+((char)('a'+i));
                count[i]--;
            }
        }
        return answer;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String sorted=sort(strs[i]);
            if(map.get(sorted)==null){
                List<String> temp=new ArrayList<>();
                temp.add(strs[i]);
                map.put(sorted,temp);
            }
            else{
                List<String> temp=map.get(sorted);
                temp.add(strs[i]);
                map.put(sorted, temp);
            }
        }
        List<List<String>> answer=new ArrayList<List<String>>();
        for(Map.Entry<String, List<String>> e:map.entrySet()){
            System.out.println(e.getKey());
            answer.add(e.getValue());
        }
        return answer;
    }
}