package answer1_10;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

/*判断数字是不是回环数字*/
public class PalindromeNumber9 {

    public boolean isPalindrome(int x) {

        if (x<0) return false;
        if(x==0) return true;

        Stack <Integer> stack = new Stack<>();
        Queue <Integer> queue = new LinkedList<>();

        while (x>0){
            stack.push(x%10);
            queue.add(x%10);
            x = x/10;
        }
        while (!stack.isEmpty()){
            if(!stack.pop().equals(queue.poll())){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome3L(int x) {
        return Objects.equals(String.valueOf(x), new StringBuilder(String.valueOf(x)).reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber9().isPalindrome3L(121));
        System.out.println(new PalindromeNumber9().isPalindrome3L(-121));
        System.out.println(new PalindromeNumber9().isPalindrome3L(123));
    }
}
