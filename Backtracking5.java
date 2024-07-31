// N - queens
import java.util.*;
public class Backtracking4{
    public static boolean isSafe(char board[][], int r, int c){
        //vertically up
        for(int i= r-1; i>=0; i--){
            if(board[i][c] == 'Q'){
                return false;
            }
        }
        //diag left up
        for(int i=r-1, j=c-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        //diag right up
        for(int i=r-1, j=c+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public static boolean nQueens(char board[][], int r){
        //base
        if(r == board.length){
            //printboard(board);
            count++;
            return true;
        }
        //col. loop
        for(int j=0; j<board.length; j++){
            if(isSafe(board,r,j)){
                board[r][j] = 'Q';
                if(nQueens(board, r+1)){
                    return true;
                } //recursive call
                board[r][j] = 'x';// baktracking to get original
            }
        }
        return false;
    }
    public static void printboard(char board[][]){
        System.out.println("----chess board----");
        for(int i=0; i<board.length; i++){
             for(int j=0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }    
    } 
    
        static int count=0;
    public static void main(String[] args) {
        int n =4;
        char board[][] = new char[n][n];
        //initialize
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = 'x';
            }
        }
        if(nQueens(board, 0)){
           System.out.println("sol is possible"); 
           printboard(board);
        }
        else{
            System.out.println("not possible");
        }
        System.out.println("total ways : "+count);
    }
}