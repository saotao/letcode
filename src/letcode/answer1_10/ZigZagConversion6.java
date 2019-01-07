package letcode.answer1_10;


import java.util.ArrayList;
import java.util.List;

//Z型排列，数组，输出
public class ZigZagConversion6 {

    public static String convert(String s, int numRows) {
        int length = s.length();
        if(numRows==1||numRows>s.length()) return s;
        int i = 0;
        int x=0,y=0;
        StringBuilder stringBuilder = new StringBuilder("");
        char[][] chars = new char[numRows][length];
        for(int m = 0;m<numRows;m++){
            for(int n=0;n<length;n++){
                chars[m][n] = ' ';
            }
        }
        while (i<length){
            if(x==0) {
                while (x<numRows-1&&i<length){
                    chars[x][y] = s.charAt(i);
                    x++;
                    i++;
                }
            }
            if(x==numRows-1){
                while (x>0&&i<length){
                    chars[x][y] = s.charAt(i);
                    x--;
                    y++;
                    i++;
                }
            }
        }

        for(char[]cha : chars){
            for(char ch : cha){
                if(ch!=' ') {
                    stringBuilder.append(ch);
                }
            }
        }
        return stringBuilder.toString();
    }

    public String convert11(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("A",1));
    }


}
