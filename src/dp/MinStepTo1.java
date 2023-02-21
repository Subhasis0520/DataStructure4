package dp;

import java.util.Scanner;

public class MinStepTo1 {

    public static int minStep(int n, int [] dp){
        if(n==1){
            return 0;
        }
        int ans1;
        if (dp[n-1] ==-1) {
            ans1 = minStep(n - 1, dp);
            dp[n-1] = ans1;
        }else {
            ans1 = dp[n-1];
        }

        int ans2 = Integer.MAX_VALUE;
        if (n%2 == 0){
            if(dp[n/2] == -1) {
                ans2 = minStep(n / 2, dp);
                dp[n/2] = ans2;
            }else{
                ans2 = dp[n/2];
            }
        }

        int ans3 = Integer.MAX_VALUE;
        if (n%3 == 0){
            if (dp[n/3] == -1) {
                ans3 = minStep(n / 3, dp);
                dp[n/3] = ans3;
            }else {
                ans3 = dp[n/3];
            }
        }

        int myAns = Math.min(ans1,Math.min(ans2,ans3))+1;
        return myAns;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the num: ");
        int n = sc.nextInt();
        int dp[] = new int[n+1];

        for (int i =0; i<dp.length;i++){
            dp[i] = -1;
        }
        int step = minStep(n,dp);
        System.out.println("Minimum steps from "+ n+" to 1 is: "+step);
    }
}
