package letcode.answer1_10;
/*string to integer -00001-23-  -> 0*/
public class StringtoInteger8 {

    public static int myAtoi(String str) {
        if(str==null|| str.equals("")) return 0;
        int i = 0;
        boolean isMinus = false;
        String re = "";
        while (str.charAt(i)==' '||str.charAt(i)=='0'){
            if(i==str.length()-1) return 0;
            i++;
        }
        if(!(str.charAt(i)<58&&str.charAt(i)>47||str.charAt(i)==45||str.charAt(i)==43)){
            return 0;
        }
        if(str.charAt(i)=='-'||str.charAt(i)=='+'){
            if(str.charAt(i)=='-') isMinus = true;
            if(str.charAt(i)=='+') isMinus = false;
            i++;
            int j=i;
            while (j<str.length()&&str.charAt(j)=='0'){
                i++;
                j++;
            }
        }
        int j=i;
        while (j<str.length()&&str.charAt(j)<58&&str.charAt(j)>47){
            j++;
        }
        if(i>=str.length()) return 0;
        re = str.substring(i,j);

        if(re.equals("")) return 0;

        if(re.length()>10) return isMinus?Integer.MIN_VALUE:Integer.MAX_VALUE;
        Long result  = Long.valueOf(re);
        if(result>Integer.MAX_VALUE) return isMinus?Integer.MIN_VALUE:Integer.MAX_VALUE;
        return (int) (isMinus?-result:result);
    }


    //copy d
    public int myAtoiCopy(String num) {
        if(num == null) {
            return 0;
        }
        num = num.trim();
        if(num.length() == 0) {
            return 0;
        }

        long result = 0;
        int scannedNumCount = 0;
        boolean isNegative = false;
        boolean isNumState = false;

        for(int i = 0; i< num.length(); i++) {
            if(num.charAt(i) == '+' || num.charAt(i) == '-') {
                if(isNumState) {
                    return getResult(isNegative, result);
                }
                isNumState = true;
                isNegative = num.charAt(i) == '-';
            } else if(Character.isDigit(num.charAt(i))) {
                if(!isNumState) {
                    isNumState = true;
                }
                result = result*10 + (num.charAt(i) - '0');
                // Just save a little time to check for max conditions, we should have scanned atleast 8 numbers.
                if(scannedNumCount++ > 8) {
                    if(isNegative) {
                        if(result * -1 < Integer.MIN_VALUE) {
                            return Integer.MIN_VALUE;
                        }
                    } else if(result > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                }
            } else {
                return getResult(isNegative, result);
            }
        }
        return getResult(isNegative, result);
    }

    private int getResult(boolean isNegative, long result) {
        if(isNegative) {
            return (int)(-1*result);
        }
        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("0-1"));
    }
}
