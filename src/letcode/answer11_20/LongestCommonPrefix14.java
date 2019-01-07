package letcode.answer11_20;

import java.util.HashSet;
import java.util.Set;

/*字符串数组最长相同前缀*/
public class LongestCommonPrefix14 {

    //超时
    public String longestCommonPrefix(String[] strs) {

        if(strs==null||"".equals(strs)) return "";
        if(strs.length==1){
            return strs[0];
        }
        String result = "";
        //n2
        int minLength = Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            minLength = strs[i].length()>minLength?minLength:strs[i].length();

        }
        for(int j=0;j<minLength;j++){
            Set set = new HashSet();
            for(int k = 0;k<strs.length;k++){
                set.add(strs[k].charAt(j));
            }
            if(set.size()==1) result = strs[0].substring(0,j+1);
            else if(set.size()>1) break;
            set.clear();
        }
        return result;
    }

    public String longestCommonPrefix1(String[] strs) {

        if(strs==null||"".equals(strs)) return "";
        if(strs.length==1){
            return strs[0];
        }
        String result = "";
        //n2
        int minLength = Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            minLength = strs[i].length()>minLength?minLength:strs[i].length();

        }
        for(int j=0;j<minLength;j++){
            int m = strs[0].indexOf(j);
            for(int k = 1;k<strs.length;k++){
                if(m==strs[k].indexOf(j)) {
                    m = strs[k].indexOf(j);
                }else {
                    break;
                }
                if(k==strs.length-1){
                    result = strs[k].substring(0,j+1);
                }
            }
        }
        return result;
    }

    //solution
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }



    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(new LongestCommonPrefix14().longestCommonPrefix1(strs));
        System.out.println("答案："+new LongestCommonPrefix14().longestCommonPrefix1(new String[]{"dog","racecar","car"}));
        System.out.println("答案："+new LongestCommonPrefix14().longestCommonPrefix1(new String[]{"d","d","d"}));
        System.out.println("答案："+new LongestCommonPrefix14().longestCommonPrefix1(new String[]{"a","d","d"}));
    }

}
