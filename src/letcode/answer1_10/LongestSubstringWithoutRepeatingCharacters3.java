package answer1_10;

import java.util.*;

/**
 * 最长不重复子串
 */
public class LongestSubstringWithoutRepeatingCharacters3 {

    public static int lengthOfLongestSubstringN3(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    public static int lengthOfLongestSubstring2N(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    //模仿2n的方法
    public static int lengthOfLongestSubstring(String s) {
        char[] chs = s.toCharArray();
        int ans = 0,i=0,j=0;
        while (i<chs.length && j<chs.length){
            if(panduan(chs,i,j,chs[j])){
                i++;
            }else {
                j++;
                ans = ans>j-i?ans:j-i;
            }
        }
        return ans;
    }

    public static boolean panduan(char[] chs,int i,int j,int tag){
        if(i==j) return false;
        for(int n=i;n<j;n++){
            if(chs[n]==tag) return true;
        }
        return false;
    }


    public int lengthOfLongestSubstringN(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

}
