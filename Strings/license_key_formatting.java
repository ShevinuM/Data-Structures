/*
You are given a license key represented as a string s that consists of only alphanumeric characters and dashes.
The string is separated into n + 1 groups by n dashes. You are also given an integer k.

We want to reformat the string s such that each group contains exactly k characters,
except for the first group, which could be shorter than k but still must contain at least one character.
Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.

Return the reformatted license key.

Example 1:

Input: s = "5F3Z-2e-9-w", k = 4
Output: "5F3Z-2E9W"
Explanation: The string s has been split into two parts, each part has 4 characters.
Note that the two extra dashes are not needed and can be removed.

Example 2:

Input: s = "2-5g-3-J", k = 2
Output: "2-5G-3J"
Explanation: The string s has been split into three parts, each part has 2 characters except the first part
as it could be shorter as mentioned above.

Constraints:

1 <= s.length <= 105
s consists of English letters, digits, and dashes '-'.
1 <= k <= 104
*/

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        /*
            1. Iterate over string s, if the character = '-', ignore, else add the
            uppercase version of the character to an arraylist.
            2. Starting from the end of the arraylist,
                1. Get the character. -> 'C'
                2. Add the character to a new string. -> 'CAB'
                3. Check if the new string length is equal to k.
                4. If so append the new string to another string. 
                5. Append a dash infront
        */
        Character chr;
        ArrayList<Character> list = new ArrayList<>();
        for (int index = 0; index < s.length(); index++) {
            chr = s.charAt(index);
            if (Character.isLetter(chr)) {
                list.add(Character.toUpperCase(chr));
            } else if (Character.isDigit(chr)) {
                list.add(chr);
            }
        }
        
        String temp = "";
        String res = "";
        for (int index = list.size() - 1; index >= 0; index--) {
            chr = list.get(index);
            temp = chr + temp;
            if (temp.length() == k) {
                res = res == "" ? temp : temp + "-" + res;
                temp = "";
            }
        }
        if (temp.length() < k && temp.length() > 0) { res = res == "" ? temp : temp + "-" + res; }
        return res;
    }
}
