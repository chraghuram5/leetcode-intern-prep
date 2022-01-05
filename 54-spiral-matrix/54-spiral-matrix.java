class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        int left=0;
        int right=matrix[0].length-1;
        int top=0;
        int down=matrix.length-1;
        int i=0;
        int j=0;
        int k=0;
        while(left<=right && top<=down){
            i=top;
            for(j=left;j<=right;j++)
                list.add(matrix[i][j]);
            top++;
            if(top>down || top>=matrix.length)
                break;
            j=right;
            for(i=top;i<=down;i++)
                list.add(matrix[i][j]);
            right--;
            if(right<left || right<0)
                break;
            i=down;
            for(j=right;j>=left;j--)
                list.add(matrix[i][j]);
            down--;
            if(down<top || down<0)
                break;
            j=left;
            for(i=down;i>=top;i--)
                list.add(matrix[i][j]);
            left++;
        }
        return list;
    }
}