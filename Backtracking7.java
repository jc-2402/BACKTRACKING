//sudoku
import java.util.*;
public class Backtracking7{
    public static boolean isSafe(int sudoku[][], int r, int c, int digit){
        //col
        for(int i=0; i<=8; i++){
            if(sudoku[i][c] == digit){
                return false;
            }
        }
        //row
        for(int j=0; j<=8; j++){
            if(sudoku[r][j] == digit){
                return false;
            }
        }
        //grid // to choose / find specific grid
        int sr= (r/3)*3;
        int sc = (c/3)*3;
        //3 * 3 grid // to find specific cell in the choosen cell
        for(int i=sr; i<sr+3; i++){
            for(int j=sc; j<sc+3; j++){
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }
            return true;
    }
    public static boolean sudokusolver(int sudoku[][], int r, int c ){
        //base case
        if(r == 9){
            return true;
        }
        //recursion
        int nextrow = r, nextcol = c+1; // to move to next cell
        //to get to the next row and 1st cell of that row
        if(c+1 ==9){
            nextrow = r+1;
            nextcol = 0;
        }
        //already a digit is placed / given
        if(sudoku[r][c] != 0){
            return sudokusolver(sudoku, nextrow, nextcol);
        }
        //to place a digit
        for(int digit =0; digit <=9; digit++){
            if(isSafe(sudoku, r, c,digit)){
                sudoku[r][c] = digit; //place
                if(sudokusolver(sudoku, nextrow, nextcol)){// recursive call
                    return true;
                }
                sudoku[r][c] =0;
            }
        }
        return false;
    }
    public static void printsudoku(int sudoku[][]){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int sudoku[][] = { {0,0,8,0,0,0,0,0,0},
                           {4,9,0,1,5,7,0,0,2},
                           {0,0,3,0,0,4,1,9,0},
                           {1,8,5,0,6,0,0,2,0},
                           {0,0,0,0,2,0,0,6,0},
                           {9,6,0,4,0,5,3,0,0},
                           {0,3,0,0,7,2,0,0,4},
                           {0,4,9,0,3,0,0,5,7},
                           {8,2,7,0,0,9,0,1,3}};

        if(sudokusolver(sudoku, 0, 0)){
            System.out.println("solution exits !");
            printsudoku(sudoku);
        }else{
            System.out.println("solution does not exits !");
        }
    }
}