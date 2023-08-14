/**
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s consists of only digits and English letters.
 */

class Solution1 {
    // Brute Force Approach
    public String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            for (int r = i; r < s.length(); r++) {
                String sub = s.substring(i, r + 1);
                if (isPalindrome(sub)) {
                    if (sub.length() > longest.length()) {
                        longest = sub;
                    }
                }
            }
        }
        return longest;
    }

    public Boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        if (s.length() == 2 && s.charAt(0) == s.charAt(1)) {
            return true;
        }
        if (s.length() == 2 && s.charAt(0) != s.charAt(1)) {
            return false;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;

        /**
         * s = "abb"
         * s.length() == 1 -> false
         * s.length() == 2 -> false
         * left = 0
         * right = 2;
         * 0 <= 2 -> true
         * a != b -> true
         * return false
         */
    }
}

class Solution2 {
    // More optimized solution.
    public String longestPalindrome(String s) {
        String longest = "";
        int l, r;
        String sub;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                longest = longest + s.charAt(0);
            } else {
                // odd substrings
                l = i - 1;
                r = i + 1;
                while (l >= 0 && r < s.length()) {
                    if (s.charAt(l) != s.charAt(r)) {
                        break;
                    }
                    l--;
                    r++;
                }
                sub = s.substring(l + 1, r);
                if (sub.length() > longest.length()) {
                    longest = sub;
                }

                // even substrings
                l = i - 1;
                r = i;
                while (l >= 0 && r < s.length()) {
                    if (s.charAt(l) != s.charAt(r)) {
                        break;
                    }
                    l--;
                    r++;
                }
                sub = s.substring(l + 1, r);
                if (sub.length() > longest.length()) {
                    longest = sub;
                }
            }
        }

        return longest;
    }
}

class Solution3 {
    // Dynamic Programming Solution
    public String longestPalindrome(String s) {
        String longest = "" + s.charAt(0);
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for (int i = 1; i < s.length(); i++) {
            dp[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
            if (dp[i - 1][i]) {
                longest = s.substring(i - 1, i + 1);
            }
        }

        // first loop checks of substrings of the specified length. We start at length =
        // 3 and go up until length = s.length()
        for (int length = 3; length <= s.length(); length++) {
            // the next loop iterates through each character in thestring and checks if
            // there is a palindrome substring of length length starting from that index
            for (int index = 0; index < s.length(); index++) {
                int end = index + length - 1;
                if (end >= s.length()) {
                    break;
                }

                if (s.charAt(index) == s.charAt(end) && dp[index + 1][end - 1]) {
                    dp[index][end] = true;
                } else {
                    dp[index][end] = false;
                }

                if (dp[index][end]) {
                    if (length > longest.length()) {
                        longest = s.substring(index, end + 1);
                    }
                }
            }
        }

        return longest;
    }
}
