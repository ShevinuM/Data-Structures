/**
 * A sawtooth sequence is a sequence of numbers that alternate between
 * increasing and decreasing.
 * In other words, each element is either strictly greater than its neighbouring
 * elements
 * or strictly less than its neighbouring elements.
 *
 * Given an array of integers 'arr', the task is to count the number of
 * contiguous subarrays
 * that represent a sawtooth sequence of at least two elements.
 *
 * Examples:
 *
 * For arr = [9, 8, 7, 6, 5], the output should be solution(arr) = 4.
 * Since all the elements are arranged in decreasing order, it won't be possible
 * to form
 * any sawtooth subarrays of length 3 or more. There are 4 possible subarrays
 * containing
 * two elements, so the answer is 4.
 *
 * For arr = [10, 10, 10], the output should be solution(arr) = 0.
 * Since all of the elements are equal, none of subarrays can be sawtooth, so
 * the answer is 0.
 *
 * For arr = [1, 2, 1, 2, 1], the output should be solution(arr) = 10.
 * All contiguous subarrays containing at least two elements satisfy the
 * condition of the problem.
 * There are 10 possible contiguous subarrays containing at least two elements,
 * so the answer is 10.
 *
 * Input/Output:
 * [execution time limit] 3 seconds (java)
 * [memory limit] 1 GB
 *
 * [input] array.integer arr
 * An array of integers.
 * Guaranteed constraints:
 * 2 ≤ arr.length ≤ 105,
 * -109 ≤ arr[i] ≤ 109.
 *
 * [output] integer64
 * Return the number of sawtooth subarrays.
 */

class Solution {
    public long solution(int[] arr) {

        int window = 1;
        long res = 0;
        for (int index = 1; index < arr.length; index++) {
            if (index == arr.length - 1) {
                if (arr[index - 1] != arr[index]) {
                    res += (long) (window);
                }
                break;
            }
            if (arr[index] < arr[index - 1] && arr[index] < arr[index + 1] ||
                    arr[index] > arr[index - 1] && arr[index] > arr[index + 1]) {
                res += (long) (window);
                window++;
            } else {
                if (arr[index - 1] != arr[index]) {
                    res += (long) (window);
                }
                window = 1;
            }
        }
        return res;
    }

}