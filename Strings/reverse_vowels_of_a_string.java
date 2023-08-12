/**
 * Given a string s, reverse only all the vowels in the string and return it.
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both
 * lower and upper cases, more than once.
 *
 * Example 1:
 * Input: s = "hello"
 * Output: "holle"
 *
 * Example 2:
 * Input: s = "leetcode"
 * Output: "leotcede"
 *
 * Constraints:
 * 1 <= s.length <= 3 * 10^5
 * s consists of printable ASCII characters.
 */

class Solution1 {
    /*
     * Less optimized solution involving a stack to do the replacement
     */
    public String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        Stack<Character> stack = new Stack<>();
        // covert s to a list
        Character[] s_list = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            s_list[i] = s.charAt(i);
        }

        // iterate over s_list and add all the vowels to stack
        for (char c : s_list) {
            if (vowels.contains(Character.toLowerCase(c))) {
                stack.push(c);
            }
        }

        // iterate over s_list again, replace the vowels in stack one by one with the
        // vowels in s_list
        for (int index = 0; index < s_list.length; index++) {
            char c = s_list[index];
            if (vowels.contains(Character.toLowerCase(c))) {
                s_list[index] = stack.pop();
            }
        }

        // convert the list back to a string
        StringBuilder res = new StringBuilder();
        for (char c : s_list) {
            res.append(c);
        }

        return res.toString();

    }
}

class Solution2 {
    /*
     * More optimized solution involving two pointers to do the replacement.
     */
    public String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        
        int left = 0;
        int right = s.length() - 1;
        char[] s_arr = s.toCharArray();


        while (left < right) {
            while (!vowels.contains(Character.toLowerCase(s_arr[left])) && left < right) {
                left++;
            }
            while (!vowels.contains(Character.toLowerCase(s_arr[right])) && right > left) {
                right--;
            }
            if (left < right) {
                char temp = s_arr[left];
                s_arr[left] = s_arr[right];
                s_arr[right] = temp;
                left++;
                right--;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (char c : s_arr) {
            builder.append(c);
        }

        return builder.toString();
        
    }
}
