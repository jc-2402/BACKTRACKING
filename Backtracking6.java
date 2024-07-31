//grid ways
//find no. of ways to read from (0,0) to (n-1,m-1) in a n*m grid.
//allowed moves - right and down
import java.util.*;
public class Backtracking6{
    public static int gridways(int i, int j, int n, int m) {
     //base case
     if(i == n-1 && j == m-1){ //last cell condition (target = start)
        return 1;
     }
     else if(i == n || j == m){
        return 0;
     }
     int w1 = gridways(i+1, j, n, m);
     int w2 = gridways(i, j+1, n, m);
     return w1 +w2;
    }
    public static void main(String[] args) {
        int n=3 , m=3;
        System.out.println(gridways(0, 0, n, m));
    }
}