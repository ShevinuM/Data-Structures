/**
 * You are given an array of integers a, where each element a[i] represents the
 * length of a ribbon.
 * Your goal is to obtain k ribbons of the same length, by cutting the ribbons
 * into as many pieces as you want.
 * Your task is to calculate the maximum integer length L for which it is
 * possible to obtain at least k ribbons of length L by cutting the given ones.
 *
 * Example:
 *
 * For a = [5, 2, 7, 4, 9] and k = 5, the output should be solution(a, k) = 4.
 *
 * Here's a way to achieve 5 ribbons of length 4:
 *
 * Cut the ribbon of length 5 into one ribbon of length 1 (which can be
 * discarded) and one ribbon of length 4.
 * Cut the ribbon of length 7 into one ribbon of length 3 (which can be
 * discarded) and one ribbon of length 4.
 * Use the existing ribbon of length 4 (no need to cut it).
 * Cut the ribbon of length 9 into two ribbons of length 4 (and one of length 1
 * which can be discarded).
 * Discard the ribbon of length 2.
 * And since it wouldn't be possible to make 5 ribbons of any greater length,
 * the answer is 4.
 *
 * For a = [1, 2, 3, 4, 9] and k = 6, the output should be solution(a, k) = 2.
 *
 * Here's one way we could make 6 ribbons of length 2:
 *
 * Cut the ribbon of length 9 into four ribbons of length 2 and one ribbon of
 * length 1 (which won't be used).
 * Cut the ribbon of length 4 into two ribbons of length 2.
 * Ignore all other ribbons (1, 2, and 3). Even though ribbons with lengths 2
 * and 3 can also be used to obtain the ribbon of length 2, we don't need more
 * than 6 ribbons of that length.
 * It would technically be possible to make 6 ribbons of a length as great as
 * 2.25, but since only integer values are allowed, the answer is 2.
 *
 * Input/Output:
 *
 * [execution time limit] 3 seconds (java)
 * [memory limit] 1 GB
 * [input] array.integer a
 * An array of the ribbons' lengths.
 * Guaranteed constraints: 1 ≤ a.length ≤ 105, 1 ≤ a[i] ≤ 109.
 * [input] integer k
 * The number of equal-length ribbons you need to obtain. It is guaranteed that
 * it is possible to obtain this number of ribbons from the values in a.
 * Guaranteed constraints: 1 ≤ k ≤ min(sum(a[i]), 109).
 * [output] integer
 * The maximum possible length of the obtained k ribbons.
 */

class Solution {
    public int solution(int[] a, int k) {
        /*
         * a = [5, 2, 7, 4, 9]
         * -----
         * --
         * -------
         * ----
         * ---------
         * 
         * max_size possible = minimum in a.
         * min_size possible = 1
         * 
         * we can use binary search
         */
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > right) {
                right = a[i];
            }
        }
        int left = 1;
        int res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canObtain(a, mid, k)) {
                left = mid + 1;
                res = mid;
            } else {
                right = mid - 1;
            }
        }
        return res;

        /*
         * right = 9
         * left = 1
         * res = 0
         * 1 <= 9 -> true
         * mid = 9 + 1 // 2 = 5
         * canObtain(a, 5, 5) -> false
         * right = 4
         * 1 <= 4 -> true
         * mid = 4 + 1 // 2 = 2
         * canObtain(a, 2, 5) -> true
         * left = 3
         * res = 2
         * 3 <= 4 - > true
         * mid = 3 + 4 // 2 = 3
         * canObtain(a, 3, 5) -> true
         * left = 4
         * res = 3
         * 4 <= 4 -> true
         * mid = 4
         * canObtain(a, 4, 5) -> true
         * left = 5
         * res = 4
         * 5 <= 4 -> false
         * return -> res = 4
         */
    }

    public Boolean canObtain(int[] a, int size, int k) {
        int pieces = 0;
        for (int i = 0; i < a.length; i++) {
            pieces += a[i] / size;
        }
        return pieces >= k;
    }
}