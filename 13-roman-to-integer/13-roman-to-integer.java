class Solution {
    public static HashMap<String, Integer> map;
    public static int helper(String A){
        if(A.length()==0)
            return 0;
        if(A.length()==1)
            return map.get(A);
        if(map.get(A.substring(0,2))!=null)
            return map.get(A.substring(0,2))+helper(A.substring(2, A.length()));
        return map.get(A.substring(0,1))+helper(A.substring(1,A.length()));
    }
    public int romanToInt(String s) {
        String[] k={"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        map=new HashMap<String, Integer>();
        for(int i=0;i<k.length;i++)
            map.put(k[i],arr[i]);
        return helper(s);
    }
}