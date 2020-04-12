package answer1_10;

import java.util.*;

/*反转数字，主要问题是int 值边界问题*/
public class ReverseInteger7 {

    public static int reverse(int x) {
        int result = 0;
        StringBuilder stringBuilder = new StringBuilder();
        boolean isMinus = x<0;
        if(isMinus) x = -x;
        while (x>0){
            stringBuilder.append(x%10);
            x = x/10;
        }
        try {
            result = Integer.parseInt(stringBuilder.toString());
        }catch (Exception e){
            return 0;
        }
        return result*(isMinus?-1:1);
    }

    public static int reversex(int x) {
        long result = 0;
        boolean isMinus = x<0;
        if(isMinus) x = -x;
        Queue<Integer> queue = new LinkedList<Integer>();
        while (x>0){
            queue.add(x%10);
            x = x/10;
        }
        while (queue.size()>0){
            result += pow(10,queue.size()-1)*queue.poll();
        }
        if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE) return 0;

        return (int) (result*(isMinus?-1:1));
    }

    public static Long pow(int tem,int fang){
        long x = 1;
        for(int i=0;i<fang;i++){
            x*=tem;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1563847412));

//        System.out.println(Math.pow(10,9)*9);
    }

}
