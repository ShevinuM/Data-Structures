/**
 * Merges all overlapping intervals in a given array of intervals and returns an array of the non-overlapping intervals
 * that cover all the intervals in the input.
 *
 * Each interval is represented as an array of two integers where the first integer is the start point and the second 
 * integer is the end point.
 * Overlapping intervals are merged into single intervals.
 * 
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, they are merged into [1,6].
 *
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping and thus merged into [1,5].
 *
 * Constraints:
 * The length of the intervals array is between 1 and 10^4, inclusive (1 <= intervals.length <= 10^4).
 * Each sub-array (interval) contains exactly 2 integers (intervals[i].length == 2).
 * The start and end points of each interval are between 0 and 10^4, inclusive (0 <= starti <= endi <= 10^4).
 */
class Solution {
    /*
     * I'm first sorting the intervals by the first number of each interval.
     * Then I create intervals as I iterate through the sorted intervals and once the interval finishes, I add it to the
     * result list. I also add the last interval to the result list since it won't be added in the loop. At the end, I
     * convert the list to an array and return it.
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) { return intervals; }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> res = new ArrayList<>();
        int[] curr = intervals[0];

        for (int outer = 1; outer < intervals.length; outer++) {
            if (intervals[outer][0] >= curr[0] && intervals[outer][0] <= curr[1]) {
                curr = new int[]{curr[0], Math.max(intervals[outer][1], curr[1])};
            } else {
                res.add(curr);
                curr = intervals[outer];
            }
            if (outer == intervals.length - 1) { res.add(curr); }
        }
        int[][] res2 = new int[res.size()][2];
        return res.toArray(res2);
    }
}


