package backtracking;

public class RatInMazRoots {

    public static void ratInAMaze(int maze[][]) {
        int n = maze.length;
        int path[][] = new int[n][n];
        printAllMaze(maze, 0, 0, path);
    }

    public static void printAllMaze(int[][] maze, int i, int j, int[][] path) {
        int n = maze.length;
//        check if i,j cell is valid or not
        if (i<0 || i>=n || j<0 || j>=n || maze[i][j] ==0 || path[i][j]==1 ){
            return;
        }

//        include cell in current path
        path[i][j] = 1;
//        Destination cell
        if (i==(n-1) && j== n-1){
            for (int r=0;r<n;r++){
                for (int c=0;c<n;c++){
                    System.out.print(path[r][c]);
                }
                System.out.println("");
            }
            path[i][j] =0;
            System.out.println();
            return;
        }

//        Explore further all the direction
//        top
        printAllMaze(maze,i-1,j,path);
//        right
        printAllMaze(maze,i,j+1,path);
//        down
        printAllMaze(maze,i+1,j,path);
//        left
        printAllMaze(maze,i,j-1,path);
        return;
    }

    public static void main(String[] args) {
        int maze[][] = {{1,1,0},{0,1,1},{1,1,1}};
        ratInAMaze(maze);
    }
}
