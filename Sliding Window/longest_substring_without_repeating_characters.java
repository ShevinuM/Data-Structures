/**
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 * 
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a
 * substring.
 * 
 * Constraints:
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 */

class Solution {

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int l = 0;
        int r;
        int res = 0;
        for (r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (set.contains(c)) {
                while (set.contains(c)) {
                    char toRemove = s.charAt(l);
                    set.remove(toRemove);
                    if (r - l > res) {
                        res = r - l;
                    }
                    l++;
                }
                set.add(c);
            } else {
                set.add(c);
            }
        }
        return res < r - l ? r - l : res;
    }

    /**
     * s = "aab" s.length = 3
     * set = {}
     * l = 0
     * res = 0
     * r = 0
     * c = a
     * set = {'a'}
     * r = 1
     * c = a
     * set.contains('a') -> true
     * set.contains('a') -> true
     * toRemove = 'a'
     * set = {}
     * 1 > 0 -> true so res = 1
     * l = 1
     * set = {'a'}
     * r = 2
     * c = b
     * 
     */

    /**
     * Input: s = "pwwkew" s.length = 6
     * set = {}
     * l = 0
     * r
     * res = 0
     * r = 0 ; 0 < 6;
     * c = p
     * set = {'p'}
     * r = 1 ; 1 < 6
     * c = w
     * set = {'p', 'w'}
     * r = 2 ; 2 < 6
     * c = w
     * set.contains(w) -> true;
     * toRemove = p
     * set = {'w'}
     * 2-0 > 0 -> true
     * res = 2
     * l = 1
     * set.contains(w) -> true;
     * toRemove = w
     * set = {}
     * l = 2
     * set.contains(w) -> false;
     * set = {'w'}
     * r = 3; 3 < 6 -> true
     * c = k
     * set = {'w','k'}
     * r = 4; 4 < 6 -> true
     * c = e
     * set = {'w', 'k', 'e'}
     * r = 5; 5 < 6 -> true
     * c = w
     * set.contains('w') -> true
     * set.contains('w') -> true
     * toRemove = w
     * set = {'k', 'e'}
     * 5-2 = 3 > res so res = 3
     * l = 3
     */
}
