package letcode.answer41_50;

//字符串乘法、寻常做法
public class MultiplyStrings43 {

    public String multiply(String num1, String num2) {
        if(num1==null||"".equals(num1)){
            return num2;
        }else if(num2==null||"".equals(num2))return num1;
        String result = multiplyOne(num1.charAt(num1.length()-1), num2, 0);
        for(int i = num1.length()-2,j=1;i>=0;i--,j++){
            String s = multiplyOne(num1.charAt(i), num2, j);
            result = stringPlus(s,result);
        }

        return result;
    }


    private String multiplyOne(char one,String num2,int i){
        if(one=='0'||num2.charAt(0)=='0') return "0";
        int tem = one-'0';
        StringBuilder result = new StringBuilder();
        for(int j=0;j<i;j++){
            result.append(0);
        }
        int count = 0;
        for(int k = num2.length()-1;k>=0;k--){
            int ji = tem*(num2.charAt(k)-'0');
            int n = (count+ji)%10;
            count = (count+ji)/10;
            result.append(n);
        }
        if(count>0) result.append(count);
        return result.reverse().toString();
    }

    private String stringPlus(String one,String two){
        if(one==null||"".equals(one)){
            return two;
        }else if(two==null||"".equals(two))return one;
        StringBuilder result = new StringBuilder();
        int count = 0;
        int i=one.length()-1;
        int j=two.length()-1;
        while (i>=0&&j>=0){
            int he = one.charAt(i)-'0'+two.charAt(j)-'0';
            int m = (count+he)%10;
            result.append(m);
            count = (count+he)/10;
            i--;
            j--;
        }
        while (j>=0){
            int he = two.charAt(j) -'0';
            int m = (count+he)%10;
            result.append(m);
            count = (count+he)/10;
            j--;
        }
        while (i>=0){
            int he = one.charAt(i) - '0';
            int m = (count+he)%10;
            result.append(m);
            count = (count+he)/10;
            i--;
        }
        if(count>0) result.append(count);

        return result.reverse().toString();
    }

    public static void main(String[] args) {
       /* String s = new MultiplyStrings43().multiplyOne('9', "999", 1);

        System.out.println(s);
        System.out.println(9*999);

        String ss = new MultiplyStrings43().stringPlus("1","999999999999999999999");
        System.out.println(ss);
        System.out.println(9999+222);*/
        String multiply = new MultiplyStrings43().multiply("2", "3");
        String multiply1 = new MultiplyStrings43().multiply("123", "456");
        String multiply2 = new MultiplyStrings43().multiply("0", "124251341");
        String multiply3 = new MultiplyStrings43().multiply("35435145678912365124", "124125416783921786745126");
        System.out.println(multiply);
        System.out.println(multiply1);
        System.out.println(multiply2);
        System.out.println(multiply3);

        String s = new MultiplyStrings43().multiplyOne('0', "2131", 0);
        System.out.println(s);


    }
}
