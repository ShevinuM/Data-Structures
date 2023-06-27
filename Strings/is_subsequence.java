/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by 
deleting some (can be none) of the characters without disturbing the relative positions 
of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false

Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.
*/
class Solution {
    /*
     * I'm using two pointer pointed at each string. I first move the s_pointer and move the t_pointer until it reaches a 
     * character in t that's equal to the character we are looking for. I then move the s_pointer and repeat. If the
     * t_pointer goes out of bounds during a search i return false. If a s_pointer is still within bounds after executing i
     * return false.
     * 
     * Time complexity if O(n) and space complexity is O(1).
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) { return true; }
        if (t.length() == 0) { return false; }
        int s_pointer = 0;
        int t_pointer = 0;
        Character character;
        while (s_pointer < s.length() && t_pointer < t.length()) {
            character = s.charAt(s_pointer);
            while (t_pointer < t.length() && t.charAt(t_pointer) != character) {
                t_pointer++;
            }
            if (t_pointer >= t.length()) { return false; }
            s_pointer++;
            t_pointer++;
        }
        return (s_pointer >= s.length());
    }
}
