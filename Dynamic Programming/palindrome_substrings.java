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
     * Solution using dynamic programming
     */
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;

        // add single characters to dp
        for (int i=0; i<s.length(); i++) {
            dp[i][i] = true;
            res++;
        }

        // add pairs to dp if the pairs are palindromic substrings
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                dp[i-1][i] = true;
                res++;
            } else {
                dp[i-1][i] = false;
            }
            
        }

        // first loop iterates over different sizes of substrings
        for (int l=3; l<=s.length(); l++) {
            // second loop starts from the 0th index and check if there is a palindrome of that size
            for (int i=0; i<s.length(); i++) {
                int end = i + l - 1;
                if (end >= s.length()) { break; }

                if (s.charAt(i) == s.charAt(end) && dp[i+1][end-1] == true) {
                    dp[i][end] = true;
                    res++;
                } else {
                    dp[i][end] = false;
                }
            }
        }

        return res;
        
    }
}

