package recursion;

import java.util.Scanner;

public class Subsequences {

    public static String[] subsequences(String input){
//        base case
        if (input.length() == 0){
            String[] output = new String[1];
            output[0] = "";
            return output;
        }
        String[] smallOutput = subsequences(input.substring(1));
        String[] output = new String[2*smallOutput.length];

        for (int i =0; i<smallOutput.length; i++){
            output[i] = smallOutput[i];
        }
        for (int i =0; i<smallOutput.length; i++){
            output[smallOutput.length + i] = input.charAt(0) + smallOutput[i];
        }

        return output;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String input = sc.next();
        String [] output = subsequences(input);

        for (String s:output) {
            System.out.println(s);
        }
    }
}
