/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.

Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true

Constraints:
1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.
*/

class Solution {
    /*
     * For this problem, I'm using a HashMap to store the characters of the ransomNote. Then I iterate over the characters in magazine and remove them from 
     * the HashMap if they exist. If the HashMap is empty, then we know that the ransomNote can be constructed from the magazine.
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        int toPut;

        for (char c: ransomNote.toCharArray()) {
            toPut = map.getOrDefault(c, 0);
            map.put(c, toPut+1);
        }

        for (char c: magazine.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                if (map.get(c) == 0) { map.remove(c); }
                if (map.isEmpty()) {return true; }
            }
        }

        return false;
    }
}