class Solution {
    public int compress(char[] chars) {
        int k=0;
        char current=chars[0];
        int count=1;
        for(int i=1;i<chars.length;i++){
            if(chars[i]==current)
                count++;
            else{
                chars[k++]=current;
                String temp=count+"";
                if(!temp.equals("1")){
                    for(int j=0;j<temp.length();j++)
                        chars[k++]=temp.charAt(j);
                }
                current=chars[i];
                count=1;
            }
        }
        chars[k++]=current;
        String temp=count+"";
        if(!temp.equals("1")){
            for(int j=0;j<temp.length();j++)
                chars[k++]=temp.charAt(j);
        }
        return k;
    }
}