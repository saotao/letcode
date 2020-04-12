package answer11_20;

import java.util.Stack;

/*验证括号匹配*/
public class ValidParentheses_20 {


    //stack
    public boolean isValid(String s) {

        if(s==null||s.length()==0) return true;
        Stack<Character> stack = new Stack();
        stack.push(s.charAt(0));
        int i=1;
        while (i<s.length()){
            if(!stack.isEmpty()&&((stack.peek()=='('&&s.charAt(i)==')')||
                    (stack.peek()=='{'&&s.charAt(i)=='}')||
                    (stack.peek()=='['&&s.charAt(i)==']'))){
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
            i++;
        }
        return stack.isEmpty();
    }

    //array❌
    public boolean isValidArray(String s){
        int flag1= 0;
        int flag2 = 0;
        int flag3=0;
        char []chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='(') flag1++;
            else if(chars[i]=='{') flag2++;
            else if(chars[i]=='[') flag3++;
            else if(flag1>0&&chars[i]==')') flag1--;
            else if(flag2>0&&chars[i]=='}') flag2--;
            else if(flag3>0&&chars[i]==']') flag3--;
        }
        return flag1==0&&flag2==0&&flag3==0;
    }

    public static void main(String[] args) {
        new ValidParentheses_20().isValidArray("()[]{}");
    }
}
