/*
 * Implement a function pow(x, n) which calculates x raised to the power n (i.e., x^n).
 *
 * Example 1:
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 *
 * Example 2:
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 *
 * Example 3:
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 *
 * Constraints:
 * -100.0 < x < 100.0
 * -2^31 <= n <= 2^31-1
 * n is an integer.
 * Either x is not zero or n > 0.
 * -10^4 <= x^n <= 10^4
 */

 /*
  * This solution uses recursion and divide and conquer approach to solve the problem. For example:
  * x^10 = (x^5) * (x^5) = ((x^2)*(x^3)) * ((x^2)*(x^3))
  * I'm using long for N because if n is Integer.MIN_VALUE, then -n will overflow.
  */
class Solution {
    public double myPow(double x, int n) {
        if (x == 0) { return 0; }
        if (n == 0) { return 1; }
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
            return calc(x, N);
        } else {
            return calc(x, N);
        }
    }

    public double calc(double x, long n) {
        if (n == 1) {
            return x;
        }
        double value = calc(x, n/2);
        if (n - n/2 != n/2) {
            return value * value * x;
        } else {
            return value * value;
        }
    }
}
