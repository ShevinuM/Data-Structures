/*
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent 
the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given 
an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals 
still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105
*/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        if (intervals.length == 0) {
            res.add(newInterval);
        }
        int index = 0;
        while (index < intervals.length) {
            int[] interval = intervals[index];
            if (newInterval[1] < interval[0]) {
                res.add(newInterval);
                for (int i = index; i < intervaPs.length; i++) {
                    res.add(intervals[i]);
                }
                break;
            } else if (newInterval[0] > interval[1]) {
                if (index == intervals.length - 1) {
                    res.add(interval);
                    res.add(newInterval);
                    break;
                } else {
                    res.add(interval);
                    index++;
                }
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
                if (index == intervals.length - 1) {
                    res.add(newInterval);
                }
                index++;
            }
        }
        return res.toArray(new int[res.size()][]);

        /**
         * intervals = [[1,3],[6,9]], intervals.length = 2
         * newInterval = [2,5]
         * index = 0
         * 0 < 2 -> true
         * interval = intervals[0] = [1,3]
         * newInterval[1] = 5 < interval[0] = 1 -> false
         * newInterval[0] > interval[1] = 2 > 3 -> false
         * newInterval[0] = min(2, 1) = 1
         * newInterval[1] = max(5, 3) = 5
         * newInterval = [1,5]
         * index = 1
         * 1 < 2 -> true
         * interval = intervals[1] = [6,9]
         * newInterval[1] < interval[0] = 5 < 6 -> true
         * res = [[1,5]]
         * i = 1; i < 2 -> true
         * res = [[1,5],[6,9]]
         * i = 2; 2 < 2 -> false
         * break
         */
    }
}
