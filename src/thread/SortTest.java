package thread;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Description
 * Date 2020-03-25 10:30
 */
public class SortTest {

    /**
     * 冒泡排序
     * 稳定，将最大值冒泡到最后一位
     */
    private static int[] maopao(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int[] maopao = copy(array);
        for (int i = 0; i < maopao.length; i++) {
            for (int j = 0; j < maopao.length - 1 - i; j++) {
                if (maopao[j] > maopao[j + 1]) {
                    int temp = maopao[j];
                    maopao[j] = maopao[j + 1];
                    maopao[j + 1] = temp;
                }
            }
        }
        return maopao;
    }

    /**
     * 选择排序
     * 不稳定，挑出最大或者最小放到首位
     */
    private static int[] xuanze(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int[] xuanze = copy(array);
        for (int i = 0; i < xuanze.length; i++) {
            for (int j = i + 1; j < xuanze.length; j++) {
                if (xuanze[i] > xuanze[j]) {
                    int temp = xuanze[i];
                    xuanze[i] = xuanze[j];
                    xuanze[j] = temp;
                }
            }
        }
        return xuanze;
    }

    /**
     * 插入排序
     */



    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 5, 1, 3, 4, 5, 2, 3, 8, 111, 33, -1, -3, -4, -1};
        // 选择
        int[] xuanzeArray = xuanze(array);
        System.out.println(Arrays.stream(xuanzeArray).boxed().collect(Collectors.toList()).toString());

        // 冒泡
        int[] maopaoArray = maopao(array);
        System.out.println(Arrays.stream(maopaoArray).boxed().collect(Collectors.toList()).toString());
    }

    private static int[] copy(int[] array) {
        int[] xuanze = new int[array.length];
        for (int i=0;i < array.length; i++) {
            xuanze[i] = array[i];
        }
        return xuanze;
    }
}
