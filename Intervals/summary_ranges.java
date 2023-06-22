/**
 * Given a sorted unique integer array nums.
 *
 * A range [a,b] is the set of all integers from a to b (inclusive).
 *
 * The task is to return the smallest sorted list of ranges that cover all the numbers in the array exactly. 
 * That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such 
 * that x is in one of the ranges but not in nums.
 *
 * Each range [a,b] in the list should be output as:
 * "a->b" if a != b
 * "a" if a == b
 * 
 * Example 1:
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 
 * Example 2:
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * 
 * Constraints:
 * 0 <= nums.length <= 20
 * -2^31 <= nums[i] <= 2^31 - 1
 * All the values of nums are unique.
 * nums is sorted in ascending order.
 */
class Solution {
    /*
     * In this solution I'm using two pointers. One to keep track of the start of 
     * the interval and the other to keep track of the end of the interval. A new
     * interval is created when the element at the current index is not equal to the
     * end of the current interval. If the start and end of the interval are equal
     * then the interval is added to the list as a single element. Otherwise the
     * interval is added to the list as a range.
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> intervals = new ArrayList<>();

        // First edge case when nums is empty
        if (nums.length == 0) { return intervals; }

        int prev = nums[0];
        int start = nums[0];

        // Second edge case when nums has only one element
        if (nums.length == 1) {
            intervals.add(String.valueOf(prev));
            return intervals;
        }
        for (int index = 1; index <= nums.length; index++) {
            if (index == nums.length) {
                if (prev != start) {
                    intervals.add(start+"->"+prev);
                } else {
                    intervals.add(String.valueOf(prev));
                }
            } else {
                if (nums[index] > prev + 1) {
                    if (prev != start) {
                        intervals.add(start+"->"+prev);
                    } else {
                        intervals.add(String.valueOf(prev));
                    }
                    prev = nums[index];
                    start = nums[index];
                }
                prev = nums[index];
            }
            
        }
        return intervals;
    }
}
