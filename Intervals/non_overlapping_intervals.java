/**
 * Given an array of intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of intervals you need to remove to make the rest of
 * the intervals non-overlapping.
 *
 * Example 1:
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of the intervals are
 * non-overlapping.
 *
 * Example 2:
 * Input: intervals = [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of the intervals
 * non-overlapping.
 *
 * Example 3:
 * Input: intervals = [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're
 * already non-overlapping.
 *
 * Constraints:
 * 1 <= intervals.length <= 105
 * intervals[i].length == 2
 * -5 * 104 <= starti < endi <= 5 * 104
 */

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        /**
         * We remove the element which has the smallest end value because it has the
         * least risk
         * of overlapping. Hence we get the minimum intervals removed.
         */
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int res = 0;
        int prev_end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prev_end) {
                prev_end = intervals[i][1];
            } else {
                res++;
                prev_end = Math.min(intervals[i][1], prev_end);
            }
        }
        return res;
    }
}