package recursion;

public class SubsetOfArray {

        // Return a 2D array that contains all the subsets
        public static int[][] subsets(int input[]) {
            // Write your code here
            return subsetsHelper(input,0);
        }

        private static int[][] subsetsHelper(int[] input, int startIndex)
        {
            if (startIndex==input.length)
            {
                return new int[1][0];
            }
            int[][] temp = subsetsHelper(input, startIndex+1);
            //System.out.println("Length of 2D matrix: "+temp.length);
            int[][] smallOutput = new int[temp.length*2][];

            for (int i=0;i<temp.length;i++)
            {
                smallOutput[i] = new int[temp[i].length];
                int[] smallTemp = temp[i];
                for (int j=0;j<temp[i].length;j++)
                {
                    smallOutput[i][j]=smallTemp[j];
                }
            }

            for (int i=0;i<temp.length;i++)
            {
                smallOutput[i+temp.length] = new int[temp[i].length+1];
                smallOutput[i+temp.length][0]=input[startIndex];
                int[] smallTemp = temp[i];
                for (int j=1;j<=temp[i].length;j++)
                {
                    smallOutput[i+temp.length][j]=smallTemp[j-1];
                }
            }
        /*
        for (int i=0;i<smallOutput.length;i++)
        {
            int[] temp1 = smallOutput[i];
            for (int j=0;j<temp1.length;j++)
            {
                System.out.print(temp1[j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        */
            return smallOutput;
        }
    }