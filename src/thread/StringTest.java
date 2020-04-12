package thread;

/**
 * Description
 * Date 2020-03-24 17:36
 */
public class StringTest {

    private int i = 1;

    private static void set(String ss) {
        ss = "12313";
    }

    public static void main(String[] args) {
//        String ab = "ab";
//        String cd = "cd";
//        String abcd = "abcd";
//        String abAddCd = "ab" + "cd";
//        String abAddCd1 = ab + "cd";
//        String abAddCd2 = "ab" + cd;
//        String abAddCd3 = ab + cd;
//        String abAddCd4 = new String("abcd");
//
//        System.out.println("abcd == abAddCd: " + (abcd == abAddCd));
//        System.out.println("abcd == abAddCd1: " + (abcd == abAddCd1));
//        System.out.println("abcd == abAddCd2: " + (abcd == abAddCd2));
//        System.out.println("abcd == abAddCd3: " + (abcd == abAddCd3));
//        System.out.println("abcd == abAddCd4: " + (abcd == abAddCd4));
//        System.out.println(abcd.intern());
        StringTest stringTest = new StringTest();
        System.out.println(stringTest.i);
        stringTest.i = 10;
        System.out.println(stringTest.i);
        String aa = "313";
        System.out.println(aa);
        set(aa);
        System.out.println(aa);
    }
}
