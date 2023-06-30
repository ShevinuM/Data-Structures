/*
Given a string 's' and a dictionary of strings 'wordDict', the task is to determine if 's' can be segmented into a space-separated sequence of one or more dictionary words. Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

Constraints:

1. The length of 's' is between 1 and 300, inclusive.
2. The length of 'wordDict' is between 1 and 1000, inclusive.
3. The length of each word in 'wordDict' is between 1 and 20, inclusive.
4. 's' and each word in 'wordDict' consist of only lowercase English letters.
5. All the strings of 'wordDict' are unique.
*/
class Solution {
    /*
     * For this solution, I'm using dynamic programming to solve the problem. I'm iterating the word in 
     * reverse and check if a substring formed from that index contains a word. if so i check if the
     * remining part of the string also forms a word. Finally i return true. 
     * 
     * Time Complexity: O(n^2*m)
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        String str;
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;
        for (int index = s.length()-1; index >= 0; index--) {
            str = s.substring(index);
            for (String word : wordDict) {
                if (str.indexOf(word) == 0) { dp[index] = dp[index+word.length()]; }
                if (dp[index] == true) { break; }
            }
        }
        return dp[0];
    }
}