package ma;

import com.sun.tools.javac.util.Assert;

public class Main {

    public static void main(String[] args) {
        int a = 5,b=10;
        add(a,b);
        System.out.println(a);
        System.out.println(b);
    }

    private static void add(int a,int b){
        a = a +b;
    }
}
