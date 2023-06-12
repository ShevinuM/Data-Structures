import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *  Each row must contain the digits 1-9 without repetition.
 *  Each column must contain the digits 1-9 without repetition.
 *  Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * 
 * Note:
 *  A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 *  Only the filled cells need to be validated according to the mentioned rules.
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check for rows and columns
        char[] column = new char[board.length];
        for (int col = 0; col < board.length; col++) {
            for (int row = 0; row < board[0].length; row++) {
                if (!validArray(board[row])) { return false; }
                column[row] = board[row][col];
            }
            if (!validArray(column)) { return false; }
        }
        int[][] positions = {{0, 0}, {3, 0}, {6, 0},
                             {0, 3}, {3, 3}, {6, 3},
                             {0, 6}, {3, 6}, {6, 6}};
        char[] subBox = new char[9];
        int row;
        int col;
        for (int index = 0; index < positions.length; index++){
            int arrayIndex = 0;
            Arrays.fill(subBox, '.');
            row = positions[index][0];
            col = positions[index][1];
            for (int count = 0; count < 3; count++) {
                subBox[arrayIndex++] = board[count+row][0+col];
                subBox[arrayIndex++] = board[count+row][1+col];
                subBox[arrayIndex++] = board[count+row][2+col];
            }
            arrayIndex=0;
            if (!validArray(subBox)) { return false; }
        }
        return true;
    }

    public boolean validArray(char[] arr) {
        Set<Character> distinctArray = new HashSet<>();
        int count = 0;
        for (int index = 0; index < arr.length; index++) {
            if (Character.isDigit(arr[index])){
                count++;
                distinctArray.add(arr[index]);
            }
        }
        // if the length of the set is not equal to the number of digits, then there were duplicates
        if (distinctArray.size() != count) {
            return false;
        }
        return true;
    }
}
