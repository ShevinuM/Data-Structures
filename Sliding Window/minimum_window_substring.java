/**
 * Given two strings s and t of lengths m and n respectively, return the minimum
 * window
 * substring of s such that every character in t (including duplicates) is
 * included in the window.
 * If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C'
 * from string t.
 *
 * Example 2:
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 *
 * Example 3:
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 * Constraints:
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 *
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 */

class Solution {
    /**
     * This solution uses 2 hashmaps to store how many times each character in t is
     * present in s and t. For each window
     * in s, we check if it contains all the characters in t. If it does, we update
     * the result if the window is smaller than the current result. If it doesn't,
     * we expand the window by increasing the right pointer. If the window contains
     * all the characters in t, we shrink the window by increasing the left pointer.
     * We keep track of the smallest window that contains all the characters in t.
     * If no such window exists, we return an empty string.
     */
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        String res = "";
        boolean found = false;
        HashMap<Character, Integer> s_map = new HashMap<>();
        HashMap<Character, Integer> t_map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            t_map.put(c, t_map.getOrDefault(c, 0) + 1);
            s_map.put(c, 0);
        }
        if (s_map.containsKey(s.charAt(0)))
            s_map.put(s.charAt(0), 1);
        while (right < s.length()) {
            if (isSubstring(s_map, t_map)) {
                if (found) {
                    res = (right - left + 1) < res.length() ? s.substring(left, right + 1) : res;
                } else {
                    res = s.substring(left, right + 1);
                }
                found = true;
                if (left < right) {
                    char toRemove = s.charAt(left);
                    if (s_map.containsKey(toRemove)) {
                        s_map.put(toRemove, s_map.get(toRemove) - 1);
                    }
                    left++;
                } else {
                    return res;
                }
            } else {
                right++;
                if (right < s.length()) {
                    char toAdd = s.charAt(right);
                    if (s_map.containsKey(toAdd)) {
                        s_map.put(toAdd, s_map.get(toAdd) + 1);
                    }
                }
            }
        }
        return found ? res : "";
    }

    public boolean isSubstring(HashMap<Character, Integer> s_map, HashMap<Character, Integer> t_map) {
        for (Map.Entry<Character, Integer> entry : t_map.entrySet()) {
            char c = entry.getKey();
            if (s_map.get(c) < entry.getValue())
                return false;
        }
        return true;
    }

    /**
     * s = "ADOBECODEBANC", t = "ABC", s.length = 13
     * left = 0, right = 0, res = "", found = false
     * t_map = {A : 1, B : 1, C : 1}
     * s_map = {A : 0, B : 0, C : 0}
     * 
     * 
     */
}
