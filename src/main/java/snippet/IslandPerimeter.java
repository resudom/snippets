package snippet;

/**
 * Created by IVANMO on 26/7/2017.
 */
public class IslandPerimeter {

    public static void main(String[] args) {

        int[][] grid = {{0,1,0,0},
                        {1,1,1,0},
                        {0,1,0,0},
                        {1,1,0,0}};
        System.out.println(islandPerimeter(grid));

       String word = "USA";
       String word2 = "False";

       boolean isRightCapital = word.substring(1).toLowerCase().equals(word.substring(1))
               || word.toUpperCase().equals(word);

    }

    public static int islandPerimeter(int[][] grid) {

        int perimeter = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){

                if(grid[i][j]==1){
                    if(i==0 || grid[i-1][j]==0) perimeter++;
                    if(i==grid.length-1 || grid[i+1][j]==0) perimeter++;
                    if(j==0 || grid[i][j-1]==0) perimeter++;
                    if(j==grid[i].length-1 || grid[i][j+1]==0) perimeter++;
                }
            }
        }
        return perimeter;
    }

}
