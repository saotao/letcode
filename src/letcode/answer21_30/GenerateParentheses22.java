package letcode.answer21_30;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*n个括号排列组合，前后得匹配*/
public class GenerateParentheses22 {

    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        char[] chars = new char[2 * n];


        for (int i = 0; i < 2 * n; i++) {
            if (i < n) {
                chars[i] = '(';
            } else {
                chars[i] = ')';
            }
        }
        result.add(String.valueOf(chars));

        int i = n - 1, j = n - 1;
        digui(i, i + 1, chars);

        while (true) {
            Queue<char[]> queue = new LinkedList<char[]>();
            queue.offer(chars);
            digui(j, j - 1, queue.peek());
            if (chars != queue.peek()) {
                queue.offer(chars);
            }
            digui(i, i + 1, queue.peek());
            if (chars != queue.peek()) {
                queue.offer(chars);
            }
            queue.poll();
            if (queue.isEmpty()) break;
        }
        return result;

    }

    private void digui(int i, int tem2, char[] chars) {
        if (tem2 == 0 || tem2 == chars.length) return;

        char tmp1 = chars[tem2];
        chars[tem2] = chars[tem2];
        chars[tem2] = tmp1;
        result.add(String.valueOf(chars));

    }

    public List<String> generateParenthesishui(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }

    public static void main(String[] args) {
        new GenerateParentheses22().generateParenthesishui(3);
    }
}
