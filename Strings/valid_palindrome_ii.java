/**
 * Problem: Given a string s, return true if the s can be a palindrome
 * after deleting at most one character from it.
 * 
 * Constraints:
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 * 
 * Example 1:
 * Input: s = "aba"
 * Output: true
 * 
 * Example 2:
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 * 
 * Example 3:
 * Input: s = "abc"
 * Output: false
 */

class Solution1 {
    // Non-optimal solution
    public boolean validPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i)) {
                return true;
            }
        }
        return false;

    }

    public boolean isPalindrome(String s, int avoid) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (left == avoid) {
                left++;
            }
            if (right == avoid) {
                right--;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

class Solution2 {
    // Optimal solution
    // This solution is optimal because it only checks the string once. When we
    // encounter two characters that are not equal, we check if the string is a
    // palindrome if we remove the left character or the right character. If either
    // of those is a palindrome, then the string is a valid palindrome. This works
    // because we are only allowed to remove one character. For example
    // 'a','b',c','d','c','e','a'. Removing anything inside between b and e won't
    // result in a palindrome because relative order of characters are the same. So
    // only option is to remove b and e
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s, l) || isPalindrome(s, r);
            }
            l++;
            r--;
        }
        return true;

    }

    public boolean isPalindrome(String s, int avoid) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (left == avoid) {
                left++;
            }
            if (right == avoid) {
                right--;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
