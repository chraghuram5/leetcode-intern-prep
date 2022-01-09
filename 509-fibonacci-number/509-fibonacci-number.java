class Solution {
    public int solve(int a) {
        if(a==0)
            return 0;
        if(a==1)
            return 1;
        a--;
        long[][] ans={{1,0},{0,1}};
        long[][] mul={{1,1},{1,0}};

        for(int i=0;(1<<i)<=a;i++){
            if(i!=0){
                mul=matMul(mul,mul);
            }
            if((a&(1<<i))!=0)
                ans=matMul(ans,mul);
        }
        return (int)(ans[0][0]%(long)(1e9+7));
    }
    
    
    public long[][] matMul(long[][]r, long[][]a) {
        long j=((r[0][0]*a[0][0])%1000000007+(r[0][1]*a[1][0])%1000000007)%1000000007;
        long k=((r[0][0]*a[0][1])%1000000007+(r[0][1]*a[1][1])%1000000007)%1000000007;
        long l=((r[1][0]*a[0][0])%1000000007+(r[1][1]*a[1][0])%1000000007)%1000000007;
        long m=((r[1][0]*a[0][1])%1000000007+(r[1][1]*a[1][1])%1000000007)%1000000007;
        r[0][0]=j;
        r[0][1]=k;
        r[1][0]=l;
        r[1][1]=m;
        return r;
    }
    public int fib(int n) {
        return solve(n);
    }
}