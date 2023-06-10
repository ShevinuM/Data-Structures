import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome
 * partitioning of s.
 * 
 * Example 1:
 *  Input: s = "aab"
 *  Output: [["a","a","b"],["aa","b"]]
 * 
 * Example 2:
 *  Input: s = "a"
 *  Output: [["a"]]
 * 
 */

 class Solution {
    /**
     * This is a backtracking problem and therefore we need to explore all possible paths.
     * We first split the string into the 0th index and then we backtrack the remaining string after 0th index was removed to
     * explore other paths when the 0th index is a palindrome
     * Next we split the string into a phrase consisting of 0th and 1st index and then we backtrack the remaining string after
     * the two indices were removed to explore other paths when the phrase is a palindrome
     * We continue this process until we have exhausted all possible paths
     *       aab
     *      . .
     *     a  aa
     *    .   .
     *   a    b
     *  .
     * b
     */
    public List<List<String>> partition(String s) {
        List<String> remainingList = Arrays.asList(s.split("")); 
        List<String> phraseList = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        traverseAndAdd(phraseList, remainingList, res);
        return res;
    }

    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public void traverseAndAdd(List<String> phraseList, List<String> remainingList, List<List<String>> res) {
        if (remainingList.isEmpty()) {
            res.add(new ArrayList<>(phraseList));
            return;
        }

        String phrase;
        List<String> temp;
        for (int index = 0; index < remainingList.size(); index++) {
            temp = remainingList.subList(0,index+1);
            phrase = String.join("", temp);
            if (isPalindrome(phrase)) {
                phraseList.add(phrase);
                List<String> newRemainingList = new ArrayList<>(remainingList.subList(index+1, remainingList.size()));
                traverseAndAdd(phraseList, newRemainingList, res);
                phraseList.remove(phraseList.size() - 1);
            }
        }
    }

}