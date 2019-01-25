package ma;

public class GreedTest {

    public int moneyCount(int m){
        int []dp = new int[m+1];
        if (m<=0) return 0;
        if(m<3) return 1;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for(int i=3;i<m+1;i++){
            if(i<5){
                dp[i] = Math.min(dp[i-1],dp[i-2])+1;
            }else if(i<10){
                dp[i] = Math.min(Math.min(dp[i-1],dp[i-2]),dp[i-5])+1;
            }else {
                dp[i] = Math.min(Math.min(Math.min(dp[i - 1], dp[i - 2]), dp[i - 5]), dp[i - 10])+1;
            }
        }
        return dp[m];
    }

 void main(String[] args) {
        int i = new GreedTest().moneyCount(40);
        int i1 = new GreedTest().moneyCount(35);
        int i2 = new GreedTest().moneyCount(37);
        int i3 = new GreedTest().moneyCount(28);
        int i4 = new GreedTest().moneyCount(16);
        int i5 = new GreedTest().moneyCount(10);
        System.out.println(i);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);
        System.out.println(i5);
    }
}
