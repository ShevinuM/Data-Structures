/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * 
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * Example 2:
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        int[] coord = new int[] { 0, 0 }; // coord = [y,x]
        int[] move = new int[] { 0, 1 }; // coord = [y,x]
        ArrayList<Integer> res = new ArrayList<>();
        while (left <= right && top <= bottom) {
            if (coord[1] == right && move[1] == 1) {
                move[0] = 1;
                move[1] = 0;
                top++;
            } else if (coord[1] == left && move[1] == -1) {
                move[0] = -1;
                move[1] = 0;
                bottom--;
            } else if (coord[0] == bottom && move[0] == 1) {
                move[0] = 0;
                move[1] = -1;
                right--;
            } else if (coord[0] == top && move[0] == -1) {
                move[0] = 0;
                move[1] = 1;
                left++;
            }
            res.add(matrix[coord[0]][coord[1]]);
            coord[1] = coord[1] + move[1];
            coord[0] = coord[0] + move[0];
        }
        return res;
    }
}