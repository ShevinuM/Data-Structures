/**
 * Determines if two strings are isomorphic.
 *
 * Two strings are considered isomorphic if the characters in the first string can be replaced to get the second string.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. 
 * No two characters may map to the same character, but a character may map to itself.
 * 
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 * 
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 *
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 *
 * Constraints:
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s and t consist of any valid ASCII character.
 *
 * @param s The first input string.
 * @param t The second input string.
 * @return true if the strings are isomorphic, false otherwise.
 */
class Solution {
    /*
     * Here I'm using a hashmap which maps the characters in s to the characters in t. I'm also using a hashset to keep track of 
     * the characters in t that have already been mapped. For example, if b gets mapped to b, then d cannot be mapped to b even 
     * though d is not in the hashmap. This is because b has already been mapped to b. If we try to map d to b, then we know that 
     * the strings are not isomorphic. If there is a key already in the hashmap that is not mapped to the same value as the
     * corresponding character in t, then we know that the strings are not isomorphic.
     */
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        HashSet<Character> mapped = new HashSet<>();
        int pointer = 0;
        char key, val;

        while (pointer < s.length()) {
            key = s.charAt(pointer);
            val = t.charAt(pointer);
            if (map.containsKey(key)){
                if (val != map.get(key)) { return false; }
            } else {
                if (mapped.contains(val)) {return false; }
                map.put(key, val);
                mapped.add(val);
            }
            pointer++;
        }
        return true;
    }
}