package dp;

public class CoinWinner {

    public static String findWinner(int n, int x, int y) {

        int[] dp = new int[n + 1];
        // 0 - Whis wins ; 1 - Beerus wins
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {

            if (dp[i - 1] == 0) {
                dp[i] = 1;
            } else if ((i - x) >= 0 && dp[i - x] == 0) {
                dp[i] = 1;
            } else if ((i - y) >= 0 && dp[i - y] == 0) {
                dp[i] = 1;
            } else {
                dp[i] = 0;
            }

        }

        if (dp[n] == 1)
            return "Beerus";
        else
            return "Whis";
    }
}
