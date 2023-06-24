/**
 * Determines whether a given string follows the same pattern as provided.
 *
 * Here 'follow' means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 *
 * Example 1:
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 *
 * Example 2:
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 *
 * Example 3:
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 *
 * Constraints:
 * 1 <= pattern.length <= 300
 * pattern contains only lower-case English letters.
 * 1 <= s.length <= 3000
 * s contains only lowercase English letters and spaces ' '.
 * s does not contain any leading or trailing spaces.
 * All the words in s are separated by a single space.
 *
 * @param pattern a string containing the pattern to match
 * @param s the string to check against the pattern
 * @return true if the string s follows the pattern, false otherwise
 */
class Solution {
    /*
     * Here I'm using a hashmap which maps the characters in pattern to the words in s. I'm also using a hashset to keep 
     * track of the words that have already been mapped. I first check if the lengths of the pattern and the length of s are
     * different, if so, I return false.
     * Then I iterate through the pattern and s. For each character in pattern, I check if the character is in the hashmap. 
     * If it is, then I check if the word in s at the current index is the same as the value in the hashmap. If it is not,then
     * I return false. If the character is not in the hashmap, then I check if the word in s at the current index is in the 
     * hashset. If it is, then I return false. If it is not, then I add the character and the word to the hashmap and hashset
     */
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> values_set = new HashSet<>();
        int index = 0;
        Character key;
        String val;
        String[] s_array = s.split(" ");
        if (pattern.length() != s_array.length) { return false; }
        while (index < pattern.length()){
            key = pattern.charAt(index);
            val = s_array[index];
            if (map.containsKey(key)){
                if (!map.get(key).equals(val)) { return false; }
            } else {
                if (values_set.contains(val)) { return false; }
                map.put(key, val);
                values_set.add(val);
            }
            index++;
        }
        return true;
    }
}

