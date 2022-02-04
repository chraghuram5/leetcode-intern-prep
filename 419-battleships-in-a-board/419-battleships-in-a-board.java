class Solution {
    public static void dfs(char[][] rc, boolean[][] vis, int i, int j, int r, int c){
        if(i>=r || j>=c || i<0 || j<0)
            return;
        vis[i][j]=true;
        if((i-1)>=0 && j>=0 && !vis[i-1][j] && rc[i-1][j]=='X')
            dfs(rc, vis, i-1, j, r, c);
        if(i>=0 && (j-1)>=0 && !vis[i][j-1] && rc[i][j-1]=='X')
            dfs(rc, vis, i, j-1, r, c);
        if(i>=0 && (j+1)<c && !vis[i][j+1] && rc[i][j+1]=='X')
            dfs(rc, vis, i, j+1, r, c);
        if((i+1)<r && j>=0 && !vis[i+1][j] && rc[i+1][j]=='X')
            dfs(rc, vis, i+1, j, r, c);
    }
    public int countBattleships(char[][] board) {
        int r=board.length;
        int c=board[0].length;
        boolean vis[][]=new boolean[r][c];
        int count=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(!vis[i][j] && board[i][j]=='X'){
                    dfs(board, vis, i, j, r, c);
                    count++;
                }
            }
        }
        return count;
    }
}