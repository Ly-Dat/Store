
import java.util.ArrayList;

public class zigzag {

    public static void main(String[] args) {
        int[][] grid = {{2,1},{2,1},{2,1}};
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<grid.length; i++){
            if(i%2==0){
                for(int j=0; j<grid[i].length; j+=2){
                    arr.add(grid[i][j]);
                }
            }
            else if(grid[i].length%2==0){
                for(int j=grid[i].length-1; j>=0; j-=2){
                    arr.add(grid[i][j]);
                }
            }
            else{
                for(int j=grid[i].length-2; j>=0; j-=2){
                    arr.add(grid[i][j]);
                }
            }
        }
        for(int i:arr){
            System.out.println(i);
        }
    }
}