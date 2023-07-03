/*
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example 1:

Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Notice that an 'O' should not be flipped if:
- It is on the border, or
- It is adjacent to an 'O' that should not be flipped.
The bottom 'O' is on the border, so it is not flipped.
The other three 'O' form a surrounded region, so they are flipped.

Example 2:

Input: board = [["X"]]
Output: [["X"]]

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
*/
class Solution {

    public void solve(char[][] board) {
        /*
         * I go through the board and find all the O's that are on the border.
         * I then find all the other O's that are connected to the border O's through dfs.
         * I change these O's to C's to mark them as connected to the border and hence
         * uncapturable. 
         */
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (row == 0 || row == board.length - 1 ||
                    col == 0 || col == board[0].length - 1) {
                    if (board[row][col] == 'O') {
                        uncapture(board, row, col);
                    }
                }
            }
        }
        capture(board);
        changeCToO(board);
    }

    /*
     * I go through the board and change the remaining O's to X's.
     */
    public void capture(char[][] board) {
        for (int row = 1; row < board.length - 1; row++) {
            for (int col = 1; col < board[0].length - 1; col++) {
                if (board[row][col] == 'O') { board[row][col] = 'X'; }
            }
        }
    }

    public void uncapture(char[][] board, int row, int col) {
        if (row >= board.length || row < 0 ||
            col >= board[0].length || col < 0 ||
            board[row][col] != 'O') {
                return;
            }
        board[row][col] = 'C';
        uncapture(board, row - 1, col);
        uncapture(board, row + 1, col);
        uncapture(board, row, col - 1);
        uncapture(board, row, col + 1);
    }

    /*
     * I go through the board and change all the C's back to O's.
     */
    public void changeCToO(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'C') {
                    board[row][col] = 'O';
                }
            }
        }
    }
}