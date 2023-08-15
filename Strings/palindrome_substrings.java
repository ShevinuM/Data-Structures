/**
 * Given a string s, return the number of palindromic substrings in it.
 * A string is a palindrome when it reads the same backward as forward.
 * A substring is a contiguous sequence of characters within the string.
 * 
 * Example 1:
 * 
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 
 * Example 2:
 * 
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * Constraints:
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 */

class Solution {
    /*
     * Solved using centre expansion
     */
    public int countSubstrings(String s) {
        int left, right;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res++;
            // odd strings
            left = i - 1;
            right = i + 1;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    res++;
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            // even strings
            left = i - 1;
            right = i;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    res++;
                    left--;
                    right++;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
