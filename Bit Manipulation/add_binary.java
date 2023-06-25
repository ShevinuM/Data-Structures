/**
 * This function adds two binary numbers represented as strings and returns their sum as a binary string.
 * 
 * <p>Example 1:</p>
 * <pre>
 * Input: a = "11", b = "1"
 * Output: "100"
 * </pre>
 * <p>Example 2:</p>
 * <pre>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * </pre>
 *
 * @param a The first binary string. It should only consist of '0' or '1' characters. The length should be 1 <= a.length <= 104.
 *          The string does not contain leading zeros except for the zero itself.
 * @param b The second binary string. It should only consist of '0' or '1' characters. The length should be 1 <= b.length <= 104.
 *          The string does not contain leading zeros except for the zero itself.
 * @return The sum of the input binary strings a and b, represented as a binary string.
 */

class Solution {
    public String addBinary(String a, String b) {
        int a_index = a.length()-1;
        int b_index = b.length()-1;
        int bin_sum, dec_sum, num1, num2;
        int bin_carry = 0;
        String res = "";

        while (a_index >= 0 || b_index >= 0){
            num1 = (a_index >= 0) ? Character.getNumericValue(a.charAt(a_index)) : 0;
            num2 = (b_index >= 0) ? Character.getNumericValue(b.charAt(b_index)) : 0;
            dec_sum = num1 + num2 + bin_carry;
            bin_sum = dec_sum%2; 
            bin_carry = dec_sum/2;
            res = Integer.toString(bin_sum) + res;
            a_index--;
            b_index--;
        }
        return (bin_carry == 1) ? "1"+res : res;
    }
}