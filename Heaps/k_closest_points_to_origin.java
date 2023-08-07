/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the
 * X-Y plane and an integer k,
 * return the k closest points to the origin (0, 0).
 * 
 * The distance between two points on the X-Y plane is the Euclidean distance
 * (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * 
 * You may return the answer in any order. The answer is guaranteed to be unique
 * (except for the order that it is in).
 * 
 * Example 1:
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest k = 1 points from the origin, so the answer is just
 * [[-2,2]].
 * 
 * Example 2:
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 * Output: [[3,3],[-2,4]]
 * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 * 
 * Constraints:
 * 1 <= k <= points.length <= 104
 * -104 <= xi, yi <= 104
 */

class Solution1 {
    public int[][] kClosest(int[][] points, int k) {
        /*
         * points[i] = [xi, yi]
         * 
         * First we can iterate over points
         * For each point we can calculate the distance to origin
         * We can have a hashmap which maps the distance to the point.
         * Then add the distance and the point
         * Then add that to the priority queue
         * 
         * Next we can have another loop which iteraters utill k
         * For each iteration we can remove an element from the priority queue
         * For the removed element, we can find the value of the priority queue.
         * We remove the element at first index and put the rest to the hashmap back.
         */
        double distance;
        HashMap<Double, Set<int[]>> map = new HashMap<>();
        PriorityQueue<Double> pq = new PriorityQueue<>();
        Set<int[]> set;
        int[][] res = new int[k][2];
        for (int[] point : points) {
            distance = Math.sqrt(Math.pow((point[0] - 0), 2) + Math.pow((point[1] - 0), 2));
            set = map.getOrDefault(distance, new HashSet<>());
            set.add(point);
            map.put(distance, set);
            pq.add(distance);
        }

        int count = 0;
        while (count < k) {
            distance = pq.poll();
            set = map.get(distance);
            for (int[] point : set) {
                res[count][0] = point[0];
                res[count][1] = point[1];
                count++;
                if (count >= k) {
                    return res;
                }
            }
        }
        return res;
    }
}

// Optimized Solution
class Solution2 {
    public int[][] kClosest(int[][] points, int k) {
        /*
         * I think the question purposely misled up giving the equation for the distance
         * between two points. we can use a custom
         * comparator for the priority queue which will compare the distance between the
         * origin and the point. This comparator
         * calaculates the difference by subtracting the the sum of the squares of the
         * point at the top of the priority queue with the sum of the squares of the
         * current point. When the sum of squares at the top of the queue is larger, it
         * will be pushed
         * to the back of the queue. When the sum of squares at the top of the queue is
         * smaller, it will be pushed to the front of the queue. This will ensure that
         * the points with the smallest distance will be at the front of the queue.
         */
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        int[][] res = new int[k][2];

        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int count = 0;
        int[] point;
        while (pq.size() > 0 && count < k) {
            point = pq.poll();
            res[count][0] = point[0];
            res[count][1] = point[1];
            count++;
        }
        return res;
    }
}