package dp;

public class Knapsack {
    public static int knapsack(int W, int[] wt, int[] value, int i) {

        if(i==value. length) {
            return 0;
        }

        int ans;
        if (W>= wt[i]){
              int ans1 = value[i] + knapsack(W-wt[i],wt, value, i+1);
              int ans2 = knapsack(W, wt, value, i+1);
              ans = Math.max(ans1,ans2);
        }else {
           ans = knapsack(W, wt, value, i+1);
        }

        return ans;
    }


    public static void main(String[] args) {
        int wt[] ={20,25,30};
        int value[] = {300,200,100};
        int W =50;

        int ans = knapsack(W,wt,value,0);
        System.out.println(ans);
    }


}
