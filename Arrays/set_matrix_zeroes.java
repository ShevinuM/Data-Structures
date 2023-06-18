/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 * 
 * You must do it in place.
 * 
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * 
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * 
 */

 class Solution {
    /**
     * My initial solution O(n+m) space complexity. I use a set to keyy track of the position of row, column that was 0.
     * Then in a second pass, I iterate through the set and set the row and column of the matrix to zero.
     */
    public void setZeroes(int[][] matrix) {
        Set<List<Integer>> toChange = new HashSet<>();
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (matrix[row][col] == 0) {
                    toChange.add(Arrays.asList(row, col));
                }
            }
        }
        int row, col;
        for (List<Integer> pos: toChange) {
            row = pos.get(0);
            col = pos.get(1);
            matrix[row] = new int[numCols];
            for (int index = 0; index < numRows; index++) {
                matrix[index][col] = 0;
            }
        }
    }
}

/**
 * Follow up:
 * A straightforward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */

class Solution2 {
    /**
     * O(1) space complexity solution. I use the first row and first column to keep track of the rows and columns that 
     * need to be set to zero. There are two edge cases I need to handle. The first is if the first row contains a zero,
     * so to deal with this i use a boolean variable to keep track of this. Since I'm overwriting the contents of the 
     * first row and first col, I can't change it to zero if the first row contains a zero. The other edge case is if 
     * matrix[0][0] is zero. I use a seperate pass to deal with this.
     */
    public void setZeroes(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        Boolean firstRowZero = false;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    if (row > 0 ) {
                        matrix[row][0] = 0;
                    } else {
                        firstRowZero = true;
                    }
                }
            }
        }

        for (int row = 1; row < numRows; row++) {
            for (int col = 1; col < numCols; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0 ) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int row = 0; row < numRows; row++) { matrix[row][0] = 0; }
        }

        if (firstRowZero) {
            matrix[0] = new int[numCols];
        }
    }
}