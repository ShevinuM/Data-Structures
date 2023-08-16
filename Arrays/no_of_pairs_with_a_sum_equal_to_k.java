/**
 * Given an array of integers a, your task is to find how many of its contiguous
 * subarrays of length m contain a pair of integers with a sum equal to k.
 * More formally, given the array a, your task is to count the number of indices
 * 0 ≤ i ≤ a.length - m such that a subarray [a[i], a[i + 1], ..., a[i + m - 1]]
 * contains at least one pair (a[s], a[t]), where:
 * s ≠ t
 * a[s] + a[t] = k
 *
 * Example:
 * For a = [2, 4, 7, 5, 3, 5, 8, 5, 1, 7], m = 4, and k = 10, the output should
 * be solution(a, m, k) = 5.
 *
 * Input/Output:
 * [execution time limit] 3 seconds (java)
 * [memory limit] 1 GB
 * [input] array.integer a
 * The given array of integers.
 * Guaranteed constraints:
 * 2 ≤ a.length ≤ 105,
 * 0 ≤ a[i] ≤ 109.
 * [input] integer m
 * An integer representing the length of the contiguous subarrays being
 * considered.
 * Guaranteed constraints:
 * 2 ≤ m ≤ a.length.
 * [input] integer k
 * An non-negative integer value representing the sum of the pairs we're trying
 * to find within each subarray.
 * Guaranteed constraints:
 * 0 ≤ k ≤ 109.
 * [output] integer
 * An integer representing the number of subarrays that contain a pair of
 * integers with a sum of k.
 */

class Solution {
    public int solution(int[] a, int m, int k) {
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            if (i + m - 1 >= a.length) {
                break;
            }
            boolean found = false;
            int[] sub = Arrays.copyOfRange(a, i, i + m);
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int index = 0; index < sub.length; index++) {
                map.put(sub[index], map.getOrDefault(sub[index], 0) + 1);
            }
            for (int index = 0; index < sub.length; index++) {
                int num = sub[index];
                int toFind = k - num;
                if (map.containsKey(toFind) &&
                        (toFind != num || toFind == num && map.get(toFind) > 1)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                res++;
            }
        }
        return res;
    }
}
