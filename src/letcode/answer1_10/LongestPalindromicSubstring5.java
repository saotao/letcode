package answer1_10;

/*最长回环*/
public class LongestPalindromicSubstring5 {

    public static String longestPalindrome(String s) {
        String answer = "";
        int flag = -1;
        int length = s.length();
        int j=0,k=0;
        while (j<length&&k<length){
            if(flag%2==0) k++;
            else if(flag%2==1) j++;
            flag++;
            int m=j,n=k;
            while (m>=0&&n<length){
                if(s.charAt(m)==s.charAt(n)){
                    if(n-m+1>answer.length()) {
                        answer = s.substring(m, n + 1);
                    }
                    m--;
                    n++;
                }else {
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
//        System.out.println(-1%2);
    }

}
