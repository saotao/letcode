package answer11_20;

import java.util.Stack;

/*Integer to Roman*/
public class IntegertoRoman12 {

    public static String intToRoman(int num) {
        if(num<=0||num>=4000) return "";
        StringBuilder stringBuilder = new StringBuilder("");
        Stack<Integer> stack = new Stack<>();
        while (num!=0){
            stack.add(num%10);
            num=num/10;
        }
        while (!stack.isEmpty()){
            int i = stack.size();
            Integer tem = stack.pop();
            switch (i){
                case 4: {
                    for(int j=0;j<tem;j++){
                        stringBuilder.append("M");
                    }
                    break;
                }
                case 3: {
                    if(tem<4) {
                        for (int j = 0; j < tem; j++) {
                            stringBuilder.append("C");
                        }
                    }else if(tem ==4){
                        stringBuilder.append("CD");
                    }else if(tem < 9){
                        stringBuilder.append("D");
                        for (int j = 0; j < tem-5; j++) {
                            stringBuilder.append("C");
                        }
                    }else stringBuilder.append("CM");
                    break;
                }
                case 2:{
                    if(tem<4) {
                        for (int j = 0; j < tem; j++) {
                            stringBuilder.append("X");
                        }
                    }else if(tem ==4){
                        stringBuilder.append("XL");
                    }else if(tem < 9){
                        stringBuilder.append("L");
                        for (int j = 0; j < tem-5; j++) {
                            stringBuilder.append("X");
                        }
                    }else stringBuilder.append("XC");
                    break;
                }
                case 1:{
                    if(tem<4) {
                        for (int j = 0; j < tem; j++) {
                            stringBuilder.append("I");
                        }
                    }else if(tem ==4){
                        stringBuilder.append("IV");
                    }else if(tem < 9){
                        stringBuilder.append("V");
                        for (int j = 0; j < tem-5; j++) {
                            stringBuilder.append("I");
                        }
                    }else stringBuilder.append("IX");
                    break;
                }
                default:break;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
