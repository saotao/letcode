package letcode.answer31_40;


//验证数独，每一列，每一行，每一块只含1-9，有重复的则返回false;
public class ValidSudoku36 {


    int []tem = new int[9];

    public boolean isValidSudoku(char[][] board) {
        boolean result;
        result = validRow(board)&&validCol(board)&&validBox(board);
        return result;
    }

    private boolean validBox(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                int x = j/3+i/3*3;
                int y = j%3+(i%3)*3;
                if(board[x][y]=='.') continue;
                tem[board[x][y]-'0'-1]++;
            }
            if(!voild()) return false;
            reset();
        }
        return true;
    }

    private boolean validCol(char[][] board) {
        for (int i=0;i<board[0].length;i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.') continue;
                tem[board[j][i] - 1 - '0']++;
            }
            if (!voild()) return false;
            reset();
        }
        return true;
    }

    private boolean validRow(char[][] board) {

        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++) {
                if (chars[j] == '.') continue;
                tem[chars[j] - 1 - '0']++;
            }
            if (!voild()) return false;
            reset();
        }
        return true;
    }

    private void reset(){
        for(int i=0;i<9;i++){
            tem[i]=0;
        }
    }

    private boolean voild(){
        for(int i :tem){
            if(i>=2) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                int x = j/3+i/3*3;
                int y =j%3+(i%3)*3;
                System.out.print("x:"+x+"  y:"+y+"  ");
                if(j%3==0) System.out.println();
            }

                System.out.println();
        }
    }
}
