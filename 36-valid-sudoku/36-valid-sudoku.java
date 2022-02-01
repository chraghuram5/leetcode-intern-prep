class Solution {
    public boolean checkSquare(char[][] board){
        for(int i=0;i<board.length;i=i+3){
            for(int j=0;j<board[0].length;j=j+3){
                HashSet<Character> set=new HashSet<Character>();
                for(int x=i;x<i+3;x++){
                    for(int y=j;y<j+3;y++){
                        if(board[x][y]=='.')
                            continue;
                        if(set.contains(board[x][y]))
                            return false;
                        set.add(board[x][y]);
                    }
                }
            }
        }
        return true;
    }
    public boolean checkRow(char[][] board){
        for(int i=0;i<board.length;i++){
            HashSet<Character> set=new HashSet<Character>();
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.')
                    continue;
                if(set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
            }
        }
        return true;
    }
    public boolean checkCol(char[][] board){
        for(int j=0;j<board[0].length;j++){
            HashSet<Character> set=new HashSet<Character>();
            for(int i=0;i<board.length;i++){
                if(board[i][j]=='.')
                    continue;
                if(set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        // boolean rowCheck=checkRow(board);
        // boolean colCheck=checkCol(board);
        // boolean squareCheck=checkSquare(board);
        // System.out.println(rowCheck);
        // System.out.println(colCheck);
        // System.out.println(squareCheck);
        HashSet<String> set=new HashSet<String>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char c=board[i][j];
                if(c=='.')
                    continue;
                String row="("+i+""+")"+c;
                String col=c+"("+j+""+")";
                String square="("+(i/3)+""+")"+c+"("+(j/3)+""+")";
                if(set.contains(row) || set.contains(col) || set.contains(square)){
                    System.out.println(set);
                    return false;
                }
                    //return false;
                set.add(row);
                set.add(col);
                set.add(square);
            }
        }
        return true;
        //return rowCheck&&colCheck&&squareCheck;
    }
}