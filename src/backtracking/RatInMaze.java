package backtracking;


public class RatInMaze {

    public  static boolean ratInMaze(int maze[][]){
       int n = maze.length;
       int path[][] = new int[n][n];
       return solveMaze(maze,0,0,path);
    }

    public  static boolean solveMaze(int maze[][],int i, int j, int path[][]){
        int n = maze.length;
//        check if i,j cell is valid or not
        if (i<0 || i>=n || j<0 || j>=n || maze[i][j] ==0 || path[i][j]==1 ){
            return false;
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
            return true;
        }

//        Explore further all the direction
//        top
        if (solveMaze(maze,i-1,j,path)){
            return true;
        }
//        right
        if (solveMaze(maze,i,j+1,path)){
            return true;
        }
//        down
        if (solveMaze(maze,i+1,j,path)){
            return true;
        }
//        left
        if (solveMaze(maze,i,j-1,path)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int maze[][] = {{1,1,0},{0,1,0},{1,1,1}};
        System.out.println(ratInMaze(maze));
    }
}
