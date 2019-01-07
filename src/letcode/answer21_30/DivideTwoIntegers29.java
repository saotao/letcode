package letcode.answer21_30;

/*不用运算符的除法*/
public class DivideTwoIntegers29 {

    public int divide(int dividend, int divisor) {
        //Reduce the problem to positive long integer to make it easier.
        //Use long to avoid integer overflow cases.
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        //Take care the edge cases.
        if (ldivisor == 0) return Integer.MAX_VALUE;
        if ((ldividend == 0) || (ldividend < ldivisor))	return 0;

        long lans = ldivide(ldividend, ldivisor);

        int ans;
        if (lans > Integer.MAX_VALUE){ //Handle overflow.
            ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }
        return ans;
    }

    private long ldivide(long ldividend, long ldivisor) {
        // Recursion exit condition
        if (ldividend < ldivisor) return 0;

        //  Find the largest multiple so that (divisor * multiple <= dividend),
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        long sum = ldivisor;
        long multiple = 1;
        while ((sum+sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
        return multiple + ldivide(ldividend - sum, ldivisor);
    }

    /*********************************/

    public int multi(int a, int b){
        boolean minus = false;
        if(a<0) {
            minus = !minus;
            a = plus(~a,1);
        }
        if(b<0) {
            minus = !minus;
            b = plus(~b,1);
        }

        int res = 0;
        while(b != 0){
            if((b & 1) != 0)
                res = plus(res, a);
            a <<= 1;
            b >>= 1;
        }
        return minus?-res:res;
    }

    public int plus(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }

    public int minus(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
        return plus(a,-b);
    }

    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers29().plus(1,2));
        System.out.println(new DivideTwoIntegers29().plus(1,-12));
        System.out.println(new DivideTwoIntegers29().multi(2,7));
        System.out.println(new DivideTwoIntegers29().multi(1,-12));
        System.out.println(new DivideTwoIntegers29().divide(12,3));
        System.out.println(new DivideTwoIntegers29().divide(-100,-13));
    }
}
