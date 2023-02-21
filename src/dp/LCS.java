package dp;

public class LCS {

    public static int lcs(String str1,String str2, int i, int j){

        if (i == str1.length() || j== str2.length()){
            return 0;
        }

        int myAns;
        if (str1.charAt(i) == str2.charAt(j)){
            int smallAns = lcs(str1,str2,i+1,j+1);
            myAns = 1+smallAns;
        }
        else {
            int ans1 = lcs(str1,str2,i,j+1);
            int ans2 = lcs(str1,str2,i+1,j);
            myAns = Math.max(ans1,ans2);
        }

        return myAns;
    }

    public static void main(String[] args) {
        String str1 ="bcdfgjh";
        String str2 ="abcfjp";

       int ans = lcs(str1,str2,0,0);
        System.out.println(ans);
    }
}
