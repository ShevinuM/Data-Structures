/**
 * Given two arrays of integers a and b of the same length, and an integer k,
 * this function returns the number of tiny pairs encountered during the
 * simultaneous iteration through a (from left to right) and b (from right to
 * left).
 * A pair (x, y), where x is from a and y is from b, is called tiny if the
 * concatenation xy is strictly less than k.
 *
 * Example:
 * For a = [1, 2, 3], b = [1, 2, 3], and k = 31, the output should be
 * solution(a, b, k) = 2.
 * For a = [16, 1, 4, 2, 14], b = [7, 11, 2, 0, 15], and k = 743, the output
 * should be solution(a, b, k) = 4.
 *
 * Input:
 * - array.integer a: An array of non-negative integers.
 * Guaranteed constraints: 0 ≤ a.length ≤ 105, 0 ≤ a[i] ≤ 104.
 * - array.integer b: An array of non-negative integers with the same length as
 * a.
 * Guaranteed constraints: 0 ≤ b[i] ≤ 104.
 * - integer k: An integer to compare concatenated pairs with.
 * Guaranteed constraints: 0 ≤ k ≤ 109.
 *
 * Output:
 * - integer: The number of tiny pairs during the iteration.
 */

class Solution {
    public int solution(int[] a, int[] b, int k) {
        /*
         * a -> iterate from left to right
         * b -> iterate from right to left
         * (x,y) -> x from a and y from b
         * if xy < k -> tiny
         * return number of tiny
         */
        int left = 0, right = b.length - 1, tiny = 0;
        while (left < a.length) {
            int x = a[left];
            int y = b[right];
            String conc = Integer.toString(x) + Integer.toString(y);
            if (Integer.valueOf(conc) < k) {
                tiny++;
            }
            left++;
            right--;
        }
        return tiny;
    }
}
