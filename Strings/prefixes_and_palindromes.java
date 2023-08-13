/**
 * You are given a string s. Consider the following algorithm applied to this
 * string:
 *
 * Take all the prefixes of the string, and choose the longest palindrome
 * between them.
 * If this chosen prefix contains at least two characters, cut this prefix from
 * s and go back to the first step with the updated string. Otherwise, end the
 * algorithm with the current string s as a result.
 * Your task is to implement the above algorithm and return its result when
 * applied to string s.
 *
 * Note: you can click on the prefixes and palindrome words to see the
 * definition of the terms if you're not familiar with them.
 *
 * Example:
 *
 * For s = "aaacodedoc", the output should be solution(s) = "".
 *
 * The initial string s = "aaacodedoc" contains only three prefixes which are
 * also palindromes - "a", "aa", "aaa". The longest one between them is "aaa",
 * so we cut it from s.
 * Now we have string "codedoc". It contains two prefixes which are also
 * palindromes - "c" and "codedoc". The longest one between them is "codedoc",
 * so we cut it from the current string and obtain the empty string.
 * Finally the algorithm ends on the empty string, so the answer is "".
 * For s = "codesignal", the output should be solution(s) = "codesignal".
 * The initial string s = "codesignal" contains the only prefix, which is also
 * palindrome - "c". This prefix is the longest, but doesn't contain two
 * characters, so the algorithm ends with string "codesignal" as a result.
 * For s = "", the output should be solution(s) = "".
 *
 * Input/Output:
 *
 * [execution time limit] 3 seconds (java)
 * [memory limit] 1 GB
 * [input] string s
 * A string consisting of English lowercase letters.
 * Guaranteed constraints: 0 ≤ s.length ≤ 1000.
 * [output] string
 * The result of the described algorithm.
 */

class Solution {
    public String solution(String s) {
        /*
         * Break the string into it's prefixes, check if it's a palindrome, get the
         * length of the prefix and add replace max with that prefix if length of prefix
         * > max.length().
         * 
         * if max.length() >= 2 then remove this prefix from the s, then repeat the same
         * procedure above untill max.length() < 2.
         */
        if (s.length() < 1) {
            return s;
        }
        String longest;
        String check = s;
        String prefix = "";
        int length;
        int left, right;
        Boolean isPalindrome;
        do {
            longest = "";
            for (int i = 0; i < check.length(); i++) {
                isPalindrome = true;
                prefix = check.substring(0, i + 1);
                left = 0;
                right = i;
                while (left <= right) {
                    if (prefix.charAt(left) != prefix.charAt(right)) {
                        isPalindrome = false;
                        break;
                    }
                    left++;
                    right--;
                }
                if (isPalindrome && prefix.length() > longest.length()) {
                    longest = prefix;
                }
            }
            if (longest.length() >= 2) {
                check = check.substring(longest.length());
            }
        } while (longest.length() >= 2);
        return check;
    }
}
