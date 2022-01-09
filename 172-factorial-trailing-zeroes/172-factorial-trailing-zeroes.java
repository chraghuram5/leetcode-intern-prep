class Solution {
    public int trailingZeroes(int n) {
        int count=0;
        int a=5;
        while((n/a)>0){
            count=count+(n/a);
            a=a*5;
        }
        return count;
    }
}