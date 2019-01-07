package letcode.answer11_20;

import java.util.*;

/*手机键盘数字转换，然后组合顺序*/
public class LetterCombinationsofaPhoneNumber17 {

    private static Map<Integer, char[]> map;
    static {
        map = new HashMap<>();
        map.put(2, new char[]{'a','b','c'});
        map.put(3, new char[]{'d','e','f'});
        map.put(4, new char[]{'g','h','i'});
        map.put(5, new char[]{'j','k','l'});
        map.put(6, new char[]{'m','n','o'});
        map.put(7, new char[]{'p','q','r','s'});
        map.put(8, new char[]{'t','u','v'});
        map.put(9, new char[]{'w','x','y','z'});
        map.put(0, new char[]{' '});
        map.put(1, new char[]{'*'});
    }
//遍历
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if(digits == null || digits.length() == 0)
            return result;
        int l = digits.length();
        for(int i=0;i<l;i++) {

            char[] temp = map.get(Character.getNumericValue(digits.charAt(i)));
            List<String> newList = new ArrayList<>();
            for(char c : temp) {
                if(i==0) {
                    newList.add(String.valueOf(c));
                } else {
                    for(String str : result) {
                        newList.add(str + c);
                    }
                }
            }
            result = new ArrayList<>(newList);
        }
        return result;
    }

    public List<String> letterCombinations2(String digits) {

        List<String> result = new ArrayList<>();
        List<String> bian = new ArrayList<>();

        if(digits == null || digits.length() == 0)
            return result;
        int l = digits.length();
        for(int i=0;i<l;i++) {

            char[] temp = map.get(Character.getNumericValue(digits.charAt(i)));
            for(char c : temp) {
                if(i==0) {
                    result.add(String.valueOf(c));
                } else {
                    for(String str : bian) {
                        result.add(str + c);
                    }
                }
            }
            bian.clear();
            for(String str :result) {
                bian.add(str);
            }

        }
        return result;
    }


    public static void main(String[] args) {
        List<String> list = new LetterCombinationsofaPhoneNumber17().letterCombinations2("23");
        for(String s : list){
            System.out.print(s+",");
        }
    }
}
