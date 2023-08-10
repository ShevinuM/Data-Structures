/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1,
 * or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of
 * s2.
 *
 * Example:
 * 
 * 1. Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * 2. Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 * 
 * Constraints:
 * 1 <= s1.length, s2.length <= 10^4
 * s1 and s2 consist of lowercase English letters.
 */

// Non optimized solution - O(s1.length() * s2.length())
class Solution1 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        /*
         * window length = s1.length()
         * 
         */
        // s1 = "ab", s2 = "eidbaooo"
        int window_length = s1.length(); // window_length = 2
        int left = 0;
        int right = left + window_length - 1; // right = 0 + 2 - 1 -> 1 so (0,1) = window
        String substring;
        while (right < s2.length()) {
            substring = s2.substring(left, right + 1); // s2.substring(0,2) -> "ei"
            if (isPermutation(s1, substring)) {
                return true;
            }
            left++;
            right++;
        }
        return false;
    }

    public boolean isPermutation(String s1, String substring) {
        /*
         * Convert s1 to a hashmap mapping the letter to the occurence.
         * Iterate over substring and remove the subsequent letter from hashmap.
         * Check is all the letters in hashmap = 0
         */
        HashMap<Character, Integer> map = new HashMap<>();
        Character chr;
        for (int index = 0; index < s1.length(); index++) {
            chr = s1.charAt(index); // a
            map.put(chr, map.getOrDefault(chr, 0) + 1); // a -> 1
        }
        // { a -> 1, b -> 1}
        for (int index = 0; index < substring.length(); index++) {
            chr = substring.charAt(index);
            if (map.containsKey(chr)) {
                map.put(chr, map.get(chr) - 1);
            } else {
                return false;
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}

class Solution2 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        /*
         * First we initialize two hashmaps with the letters of the alphabet and 0.
         * Then we iterate over s1 and update the hashmap with the occurences of letters
         * in s1.
         */
        HashMap<Character, Integer> s1_map = new HashMap<>();
        HashMap<Character, Integer> s2_map = new HashMap<>();
        for (int ascii = 97; ascii < 97 + 27; ascii++) {
            s1_map.put((char) ascii, 0);
            s2_map.put((char) ascii, 0);
        }
        for (int index = 0; index < s1.length(); index++) {
            s1_map.put(s1.charAt(index), s1_map.get(s1.charAt(index)) + 1);
            s2_map.put(s2.charAt(index), s2_map.get(s2.charAt(index)) + 1);
        }
        if (s1_map.equals(s2_map)) {
            return true;
        }
        int window = s1.length();
        for (int index = 1; index + window - 1 < s2.length(); index++) {
            // decrement the previous value outside of window
            s2_map.put(s2.charAt(index - 1), s2_map.get(s2.charAt(index - 1)) - 1);
            s2_map.put(s2.charAt(index + window - 1), s2_map.get(s2.charAt(index + window - 1)) + 1);
            if (s1_map.equals(s2_map)) {
                return true;
            }
        }
        return false;
    }
}