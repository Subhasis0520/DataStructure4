package dp;

public class LCSIterative {

    public static int lcsI(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int dp[][] = new int[m+1][n+1];

        for (int i = m;i>=0;i--){
            for (int j = n;i>=0;j--){
                int myAns;
                if (str1.charAt(i) == str2.charAt(j)){
                    myAns = 1+dp[i+1][j+1];
                }else {
                    int ans1 = dp[i][j+1];
                    int ans2 = dp[i+1][j];
                    myAns =Math.max(ans1,ans2);
                }
                dp[i][j]  = myAns;
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        String str1 ="bcdfgjh";
        String str2 ="abcfjp";

        int ans = lcsI(str1,str2);
        System.out.println(ans);
    }
}
