package letcode.answer31_40;

import java.util.Stack;

//最长匹配括号串
public class LongestValidParentheses32 {


    //暴力破解
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
    public int longestValidParentheses(String s) {
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j+=2) {
                if (isValid(s.substring(i, j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }


    //dp
    public int longestValidParenthesesDP(String s) {
        int[] dp = new int[s.length()];
        int max = 0;

        if(s.length()<2) return 0;
        int i = 1;
        while (i<s.length()){
            if(s.charAt(i)==')'&&s.charAt(i-1)=='('){
                dp[i] = dp[i-2>=0?i-2:0]+2;
                max = max>dp[i]?max:dp[i];
            }else if(s.charAt(i)==')'&&s.charAt(i-1)==')'){
                int m =i-dp[i-1]-1;
                if(m>=0&&s.charAt(m)=='('){
                    int k = i-dp[i-1]-2;
                    dp[i] = dp[i-1]+dp[k>=0?k:0]+2;
                    max = max>dp[i]?max:dp[i];
                }
            }
            i++;
        }
        return max;
    }

    public int longestValidParenthesesdp(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        String s = "((()()()()))))()())))))()))()()())";
        new LongestValidParentheses32().longestValidParenthesesDP(s);
    }
}
