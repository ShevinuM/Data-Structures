/*
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. 
The returned string should only have a single space separating the words. 
Do not include any extra spaces.

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

Constraints:

1 <= s.length <= 10^4
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
*/

/*
 * Lesser Optimal Solution
 */
class Solution1 {
    /*
     * First i get rid of the leading and trailing whitespaces. Then I split the string by the whitespaces. I then traverse
     * the list in reverse adding each word found in the list to a string. I return the string.
     */
    public String reverseWords(String s) {
        s = s.trim();
        String[] split_string = s.split(" ");
        String new_sentence = "";
        for (int count = split_string.length - 1; count >= 0; count--) {
            if (split_string[count] == "") { continue; }
            if (count == split_string.length - 1) {
                new_sentence += split_string[count]; 
            } else {
                new_sentence = new_sentence + " " + split_string[count];
            }
        }
        return new_sentence;
    }
}

/*
 * A more optimal solution using regex matching to match multiple whitespaces and string builder to build up the string
 * which reduces the need to create a new string every time a new word is added to the string.
 */
class Solution2 {
    
    public String reverseWords(String s) {
        s = s.trim();
        String[] split_string = s.split("\\s+");
        StringBuilder new_sentence = new StringBuilder();
        for (int count = split_string.length - 1; count >= 0; count--) {
            new_sentence.append(split_string[count]);
            if (count != 0) { new_sentence.append(" "); }
        }
        return new_sentence.toString();
    }
}
