class Solution {
    public int[][] generateMatrix(int n) {
        int A=n;
        int[][] spiral=new int[A][A];
        if(A==2){
            spiral[0][0]=1;
            spiral[0][1]=2;
            spiral[1][1]=3;
            spiral[1][0]=4;
        }
        int num=1;
        int left=0;
        int right=A-1;
        int top=0;
        int down=A-1;
        int i=0;
        int j=0;
        A--;
        while(left<=right && top<=down){
            i=top;
            for(j=left;j<=right;j++)
                spiral[i][j]=num++;;
            top++;
            if(top>down || top>=A)
                break;
            j=right;
            for(i=top;i<=down;i++)
                spiral[i][j]=num++;
            right--;
            if(right<left || right<0)
                break;
            i=down;
            for(j=right;j>=left;j--)
                spiral[i][j]=num++;
            down--;
            if(down<top || down<0)
                break;
            j=left;
            for(i=down;i>=top;i--)
                spiral[i][j]=num++;;
            left++;
        }
        return spiral;
    }
}