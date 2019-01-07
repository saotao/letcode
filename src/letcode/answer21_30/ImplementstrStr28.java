package letcode.answer21_30;

public class ImplementstrStr28 {

    public int strStr1(String haystack, String needle) {

        int i = haystack.indexOf(needle);
        return i;
    }

    //KMP

    public int strStr(String haystack, String needle) {

        int[] next = GetNext(needle.toCharArray());
        return KmpSearch(haystack.toCharArray(),needle.toCharArray(),next);
    }
    private int[] GetNext(char[] p) {
        int pLen = p.length;
        int[] next = new int[pLen];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < pLen - 1) {
            //p[k]表示前缀，p[j]表示后缀
            if (k == -1 || p[j] == p[k]) {
                ++k;
                ++j;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    private int KmpSearch(char[] s, char[] p,int[] next) {
        int i = 0;
        int j = 0;
        int sLen = s.length;
        int pLen = p.length;
        while (i < sLen && j < pLen) {
            //①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
            if (j == -1 || s[i] == p[j]) {
                i++;
                j++;
            } else {
                //②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
                //next[j]即为j所对应的next值
                j = next[j];
            }
        }
        if (j == pLen)
            return i - j;
        else
            return -1;
    }

    public static void main(String[] args) {
        int[] next = new ImplementstrStr28().GetNext(new char[]
                {'B','B','C','A','B','C','D','A','B', 'A',
                'B','C','D','A','B','C','D','A','B','D','E'});
                /*"-1   0   1   0   0   1   0   0   0    1   " +
                "0   1  0   0    0   1   0   0   0   1   0"*/

        int[] next1 = new ImplementstrStr28().GetNext(new char[]{'A','B','C','D','A','B','A','C'});

        for(int i : next){
            System.out.print(i+"");
        }
        System.out.println();
        for(int i : next1){
            System.out.print(i+"");
        }
    }
}
