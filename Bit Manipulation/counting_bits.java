/**
 * This class contains methods to solve the problem of counting the number of 1's in 
 * the binary representation of numbers from 0 to n.
 *
 * Given an integer n, the methods in this class return an array of length n + 1 such that 
 * for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 * 
 * For example, if n is 2, the output is [0,1,1] because:
 * - The binary representation of 0 is 0, and there are 0 ones.
 * - The binary representation of 1 is 1, and there is 1 one.
 * - The binary representation of 2 is 10, and there is 1 one.
 * 
 * Similarly, if n is 5, the output is [0,1,1,2,1,2] because:
 * - The binary representation of 0 is 0, and there are 0 ones.
 * - The binary representation of 1 is 1, and there is 1 one.
 * - The binary representation of 2 is 10, and there is 1 one.
 * - The binary representation of 3 is 11, and there are 2 ones.
 * - The binary representation of 4 is 100, and there is 1 one.
 * - The binary representation of 5 is 101, and there are 2 ones.
 *
 * Note:
 * - The value of n is constrained to the range 0 <= n <= 105.
 * - A solution with a runtime of O(n log n) is trivial, but the aim is to find a 
 *   solution that has a linear runtime, O(n), and possibly executes in a single pass.
 * - The methods in this class should not use any built-in function to count the number 
 *   of set bits in a number (like __builtin_popcount in C++).
 */

 class Solution1 {
    // Time Complexity : O(nlgn).
    /*
     * This solution simply uses binary division and calculate the number of 1s on the process.
     */
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        if (n == 0) { return new int[]{0}; }
        for (int count = 0; count <= n; count++) {
            res[count] = binaryDivision(count);
        }
        return res;
    }

    public int binaryDivision(int n) {
        int value = n;
        int rem = 0;
        int count = 0;
        while (n != 0) {
            value = n / 2;
            rem = n - (value * 2);
            n = value;
            if (rem == 1) { count++; }
        }
        return count;
    }
}

class Solution {
    /*
    * 0 -> 0000
    * 1 -> 0001
    * 2 -> 0010
    * 3 -> 0011
    * 4 -> 0100 -> number of bits in 0 + 1
    * 5 -> 0101 -> number of bits in 1 + 1
    * 6 -> 0110 -> number of bits in 2 + 1
    * 7 -> 0111 -> number of bits in 3 + 1
    * 8 -> 1000 -> number of bits in 0 + 1
    *
    * This solution uses dynamic programming to solve the problem in linear time complexity. 
    * res[i] = res[i-offset] + 1 where offset is multiplied by 2 everytime the count is a power of 2.
    */
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        int offset = 2;
        for (int count = 0; count <= n; count++) {
            if (count == offset*2) { offset = offset*2; }
            if (count == 0) {
                res[0] = 0;
            } else if (count == 1) {
                res[1] = 1;
            } else {
                res[count] = res[count-offset] + 1;
            }
        }
        return res;
    }
}