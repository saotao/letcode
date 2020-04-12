package answer11_20;

/*roman to Integer*/
public class RomantoInteger13 {

    public int romanToInt(String s) {
        if(s==null||"".equals(s)) return 0;

        int result = 0;
        for(int i=0;i<s.length();i++){
            int j = 0,k=i+1;
            if(s.charAt(i)=='M'){
                j = 1000;
            }else if(s.charAt(i) == 'D'){
                j = 500;
            }else if(s.charAt(i) == 'L'){
                j = 50;
            }else if(s.charAt(i) == 'V'){
                j = 5;
            }else if(s.charAt(i)=='C'&&k<s.length()&&(s.charAt(k)=='M'||s.charAt(k)=='D')){
                j = -100;
            }else if(s.charAt(i)=='C'&&((k<s.length()&&(s.charAt(k)!='M'||s.charAt(k)!='D'))||k==s.length())){
                j = 100;
            }else if(s.charAt(i)=='X'&&k<s.length()&&(s.charAt(k)=='L'||s.charAt(k)=='C')){
                j = -10;
            }else if(s.charAt(i)=='X'&&((k<s.length()&&(s.charAt(k)!='L'||s.charAt(k)!='C'))||k==s.length())){
                j = 10;
            }else if(s.charAt(i)=='I'&&k<s.length()&&(s.charAt(k)=='V'||s.charAt(k)=='X')){
                j = -1;
            }else if(s.charAt(i)=='I'&&((k<s.length()&&(s.charAt(k)!='V'||s.charAt(k)!='X'))||k==s.length())){
                j = 1;
            }
            result += j;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RomantoInteger13().romanToInt("III"));
        System.out.println(new RomantoInteger13().romanToInt("IV"));
        System.out.println(new RomantoInteger13().romanToInt("IX"));
        System.out.println(new RomantoInteger13().romanToInt("LVIII"));
        System.out.println(new RomantoInteger13().romanToInt("MCMXCIV"));
    }
}
