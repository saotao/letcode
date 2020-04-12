package javatest.arraytest;

import java.util.Random;

/**
 * Description 随机数测试
 * Date 2019-10-22 14:37
 */
public class RandomTest {

    public static void main(String[] args) {
        double random = Math.random();
        System.out.println(random);

        Random random1 = new Random();
        double v = random1.nextDouble();
        double v1 = random1.nextDouble() * 100;
        System.out.println(v + "---" + v1);

        String s;

        System.out.printf("%s",s = String.valueOf(v));


        System.out.println(9-11);
    }
}
