import java.util.*;
class QueenProblem {
 
    static List<List<Integer> > result  = new ArrayList<List<Integer> >();
 
    /* A utility function to check if a queen can
    be placed on board[row][col]. Note that this
    function is called when "col" queens are
    already placed in columns from 0 to col -1.
    So we need to check only left side for
    attacking queens */
    static boolean isSafe(int board[][], int row, int col)
    {
        int i, j;
        int N = board.length;
        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;
 
        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
 
        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;
 
        return true;
    }
 
    /* A recursive utility function
    to solve N Queen problem */
    static boolean solveNQUtil(int board[][], int col)
    {
        /* base case: If all queens are placed
        then return true */
        int N = board.length;
        if (col == N) {
 
            List<Integer> v = new ArrayList<>();
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 1)
                        v.add(j + 1);
                }
            }
            result.add(v);
            return true;
        }
 
        /* Consider this column and try placing
        this queen in all rows one by one */
        boolean res = false;
        for (int i = 0; i < N; i++) {
            /* Check if queen can be placed on
            board[i][col] */
            if (isSafe(board, i, col)) {
                /* Place this queen in board[i][col] */
                board[i][col] = 1;
 
                // Make result true if any placement
                // is possible
                res = solveNQUtil(board, col + 1) || res;
 
                /* If placing queen in board[i][col]
                doesn't lead to a solution, then
                remove queen from board[i][col] */
                board[i][col] = 0; // BACKTRACK
            }
        }
 
        /* If queen can not be place in any row in
            this column col then return false */
        return res;
    }
 
    /* This function solves the N Queen problem using
    Backtracking. It mainly uses solveNQUtil() to
    solve the problem. It returns false if queens
    cannot be placed, otherwise return true and
    prints placement of queens in the form of 1s.
    Please note that there may be more than one
    solutions, this function prints one of the
    feasible solutions.*/
    static List<List<Integer> > nQueen(int n)
    {
        result.clear();
        int board[][] = new int[n][n];
        solveNQUtil(board, 0);
         
        return result;
    }
 
    // Driver code
    public static void main(String[] args)
  
    {
    	  Scanner sc = new Scanner (System.in);
    	  System.out.println("Enter the no of queens: ");
        int n =  sc.nextInt();
 
        List<List<Integer> > res = nQueen(n);
        System.out.println(res);
    }
}
 