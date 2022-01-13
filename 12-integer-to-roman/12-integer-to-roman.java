class Solution {
    public static String helper(int A){
        if(A==0)
            return "";
        if(A>=1000)
            return "M"+helper(A-1000);
        if(A>=900)
            return "CM"+helper(A-900);
        if(A>=500)
            return "D"+helper(A-500);
        if(A>=400)
            return "CD"+helper(A-400);
        if(A>=100)
            return "C"+helper(A-100);
        if(A>=90)
            return "XC"+helper(A-90);
        if(A>=50)
            return "L"+helper(A-50);
        if(A>=40)
            return "XL"+helper(A-40);
        if(A>=10)
            return "X"+helper(A-10);
        if(A>=9)
            return "IX"+helper(A-9);
        if(A>=5)
            return "V"+helper(A-5);
        if(A>=4)
            return "IV"+helper(A-4);
        if(A>=1)
            return "I"+helper(A-1); 
        return "";
    }
    public String intToRoman(int num) {
        String s=helper(num);
        return s;
    }
}