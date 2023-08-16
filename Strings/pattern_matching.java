/**
 * You are given two strings - pattern and source. The string pattern contains
 * only the symbols 0 and 1,
 * and the string source contains only lowercase English letters.
 * 
 * A pattern matches a substring source[l..r] of source if the following
 * conditions are met:
 * - They have equal length,
 * - For each 0 in pattern, the corresponding letter in the substring is a
 * vowel,
 * - For each 1 in pattern, the corresponding letter is a consonant.
 * 
 * The vowels are defined as 'a', 'e', 'i', 'o', 'u', and 'y'. All other letters
 * are consonants.
 * 
 * Your task is to calculate the number of substrings of source that match
 * pattern.
 *
 * Example:
 * For pattern = "010" and source = "amazing", the output should be
 * solution(pattern, source) = 2.
 * "010" matches source[0..2] = "ama"; "010" matches source[2..4] = "azi"; but
 * doesn't match other substrings.
 * For pattern = "100" and source = "codesignal", the output should be
 * solution(pattern, source) = 0.
 * 
 * Constraints:
 * 1 ≤ pattern.length ≤ 103
 * 1 ≤ source.length ≤ 103
 */

class Solution {
    public int solution(String pattern, String source) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('y');
        int res = 0;
        for (int i = 0; i < source.length(); i++) {
            int match = 0;
            int end = i + pattern.length() - 1;
            if (end >= source.length()) {
                break;
            }
            for (int count = 1; count <= pattern.length(); count++) {
                switch (pattern.charAt(count - 1)) {
                    case '0':
                        if (vowels.contains(source.charAt(i + count - 1))) {
                            match++;
                        }
                        break;
                    case '1':
                        if (!vowels.contains(source.charAt(i + count - 1))) {
                            match++;
                        }
                        break;
                }
                ;
            }
            if (match == pattern.length()) {
                res++;
            }
        }
        return res;

        /**
         * pattern = "010" pattern.length = 3
         * source = "amazing" source.length = 7
         * 
         * vowels = <a, e, i, o, u, y>
         * res = 0
         * i = 0 < 7 -> true
         * match = 0
         * count = 1 <= 3 -> true
         * end = 0 + 3 - 1 = 2
         * 2 >= 7 -> false
         * pattern.charAt(0) = 0
         * source.charAt(0+1-1) = a in vowels -> true
         * match = 1
         * count = 2 <= 3 -> true
         * pattern.charAt(1) = 1
         * source.charAt(0+2-1) = m not in vowels -> true
         * match = 2
         **/
    }
}
