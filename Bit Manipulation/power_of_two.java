/**
 * Given an integer n, returns true if it is a power of two. Otherwise, returns false.
 * An integer n is a power of two if there exists an integer x such that n == 2^x.
 *
 * Example 1:
 * Input: n = 1
 * Output: true
 * Explanation: 2^0 = 1
 *
 * Example 2:
 * Input: n = 16
 * Output: true
 * Explanation: 2^4 = 16
 *
 * Example 3:
 * Input: n = 3
 * Output: false
 *
 * Constraints:
 * -2^31 <= n <= 2^31 - 1
 *
 * Follow up: Could you solve it without loops/recursion?
 */

class Solution {
    public boolean isPowerOfTwo(int n) {
        double logResult = Math.log(n) / Math.log(2);
        double compare = Math.floor(logResult);
        return Math.abs(logResult - compare) < 1e-10;
    }
}
