/**
 * Checks if an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * 
 * Examples:
 * 
 * 1) Input: x = 121
 *    Output: true
 *    Explanation: 121 reads as 121 from left to right and from right to left.
 * 
 * 2) Input: x = -121
 *    Output: false
 *    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * 3) Input: x = 10
 *    Output: false
 *    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * Constraints: -2^31 <= x <= 2^31 - 1
 *
 * Follow up: A possible challenge could be solving this problem without converting the integer to a string.
 */
class Solution {
    /*
     * This solution simply reverses the number and compares if it's equal to the original number.
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int reversed = 0;
        int original = x;
        while (x > 0) {
            reversed = reversed*10 + x % 10;
            x = x / 10;
        }
        return (original == reversed);
    }
}