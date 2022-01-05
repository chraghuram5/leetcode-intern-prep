class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<String>();
        for(int i=0;i<nums.length;i++)
            list.add(Integer.toString(nums[i]));
        Comparator<String> cmp = new Comparator<String>() {
            public int compare(String o1, String o2) {
                return ((o1+o2).compareTo((o2+o1)));
            }
        };
        Collections.sort(list, cmp);
        String answer="";
        for(int i=list.size()-1;i>=0;i--)
            answer=answer+list.get(i);
        for(int i=0;i<answer.length();i++){
            if(answer.charAt(i)!='0')
                return answer;
        }
        return "0";
    }
}