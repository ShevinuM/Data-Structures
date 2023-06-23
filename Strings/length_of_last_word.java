/**
 * Returns the length of the last word in a given string. 
 * A word is defined as a maximal substring consisting of non-space characters only.
 *
 * Example 1:
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 *
 * Example 2:
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 *
 * Example 3:
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 *
 * Constraints:
 * 1 <= s.length <= 104
 * s consists of only English letters and spaces ' '.
 * There will be at least one word in s.
 *
 * @param s The input string.
 * @return The length of the last word in the string.
 */
class Solution {
    /*
     * The first loop makes sure that we start with a non-space character. The next loop is used to calculate the length of the
     * last word. It loops until we reach the beginning of the string or we reach a space character. 
     */
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') { index--; }
        int count = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            count++;
            index--;
        }
        return count;
    }
}
