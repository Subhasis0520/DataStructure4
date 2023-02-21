package dp;

public class MinCostRecursive {
    public static int minCostR(int[][] cost, int i, int j, int[][] dp) {
        int m = cost.length;
        int n = cost[0].length;
// Special Case
        if(i==m-1 && j==n-1) {
        return cost[i][j];
    }
// Base Case
         if(i>=m | j>=n) {
             return Integer.MAX_VALUE;
         }

    int ans1, ans2, ans3;
       if (dp[i+1][j] == Integer.MIN_VALUE) {
        ans1 = minCostR(cost, i+1, j,dp);
        dp[i+1][j] = ans1;
    }else{
        ans1 = dp[i+1][j];
    }
     if(dp[i][j+1] == Integer.MIN_VALUE) {
        ans2 = minCostR(cost, i, j+1,dp);
        dp[i][j+1] = ans2;
    }else{
        ans2 = dp[i][j+1];
    }
     if (dp [i+1] [j+1] == Integer.MIN_VALUE) {
        ans3 = minCostR(cost,i+1, j+1,dp);
        dp [i+1] [j+1] = ans3;
    }else{
        ans3 = dp[i+1] [j+1];
    }

     
    int myAns = cost[i][j] + Math.min(ans1, Math.min(ans2, ans3));
     return myAns;
}

    public static void main(String[] args) {
        int cost[][] = {{1,3,7},{2,3,4},{3,6,9},{15,16,18}};
        int dp[][] = new int[cost.length][cost[0].length];
        for (int i =0;i< dp.length;i++){
            for(int j=0; j<dp[0].length; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        int ans = minCostR(cost,0,0,dp);
        System.out.println(ans);
    }
}
