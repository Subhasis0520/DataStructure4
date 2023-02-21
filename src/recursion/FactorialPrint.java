package recursion;

public class FactorialPrint {

    public static void printFactorial(int input, int ans){
        if (input == 0){
            ans = 1;
            System.out.println(ans);
            return;
        }

        ans = ans * input;
        printFactorial(input-1,ans);
    }

    public static void main(String[] args) {

        printFactorial(6,1);
    }
}
