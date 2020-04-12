package javatest.arraytest;

import java.util.Arrays;

/**
 * Description array
 * Date 2019-10-22 11:17
 */
public class ArraysTest {

    public static void main(String[] args) {
        int [] i = new int[10];
        int [] j = new int[10];
        Arrays.fill(i,10);
        Arrays.fill(j,10);
        Arrays.stream(i).forEach(System.out::println);
        String s = Arrays.toString(i);
        System.out.println(s);


        String[] m = new String[13];
        String[] n = new String[12];
        Arrays.fill(m,"adc");
        Arrays.fill(n,"adc");
        m[12] = "";

        System.out.println(Arrays.deepEquals(m,n));
        String s1 = Arrays.toString(m);
        System.out.println(s1);

        System.arraycopy(m,1,n,0,12);
        Arrays.stream(n).forEach(System.out::println);
        System.out.println(Arrays.toString(n));
    }
}
