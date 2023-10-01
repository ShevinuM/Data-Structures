/**
 * Given a characters array tasks, representing the tasks a CPU needs to do,
 * where each letter represents a different task. Tasks could be done in any
 * order.
 * Each task is done in one unit of time. For each unit of time, the CPU could
 * complete either one task or just be idle.
 * 
 * However, there is a non-negative integer n that represents the cooldown
 * period
 * between two same tasks (the same letter in the array), that is that there
 * must
 * be at least n units of time between any two same tasks.
 * 
 * Return the least number of units of times that the CPU will take to finish
 * all
 * the given tasks.
 * 
 * Example 1:
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation:
 * A -> B -> idle -> A -> B -> idle -> A -> B
 * There is at least 2 units of time between any two same tasks.
 * 
 * Example 2:
 * Input: tasks = ["A","A","A","B","B","B"], n = 0
 * Output: 6
 * Explanation: On this case any permutation of size 6 would work since n = 0.
 * ["A","A","A","B","B","B"]
 * ["A","B","A","B","A","B"]
 * ["B","B","B","A","A","A"]
 * ... And so on.
 * 
 * Example 3:
 * Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 * Output: 16
 * Explanation:
 * One possible solution is
 * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle
 * -> idle -> A
 * 
 * Constraints:
 * 1 <= task.length <= 10^4
 * tasks[i] is upper-case English letter.
 * The integer n is in the range [0, 100].
 */

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // populate the map with each task and the frequence it appears
        HashMap<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        // Create a priority queue and add each value in the map to pq. The Priority
        // Queue represents the processes that can be executed. The frequency of each
        // process is stored and the element with the highest frequency is popped from
        // the priority queue. By using the most frequent element as the starting point,
        // i'm maximizing the likelihood of other less frequent elements taking up the
        // idle time thereby minimizing the total time.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int value : map.values()) {
            pq.add(value);
        }

        // Create a queue to store the future tasks.
        // Tasks are stored in the form [remaining frequency, next time it can execute]
        Queue<int[]> q = new LinkedList<>();

        int time = 0;

        while (!pq.isEmpty() || !q.isEmpty()) {

            // if the queue is not empty and the first element in the queue can be processed
            // ie meet the time constraint, we can add it to the priority queue
            if (!q.isEmpty() && q.peek()[1] <= time) {
                pq.add(q.poll()[0]);
            }

            // take the first element of the priority queue and execute it
            if (!pq.isEmpty()) {
                int remaining = pq.poll();

                // if remaining is less than or equal to 1, no point of adding to the queue
                // since the frequency will be 0 once it's executed and it can't run at any
                // point again in the future
                if (remaining > 1) {

                    // let's say time = 0 and cool down is 2, then next time it can run is time = 3,
                    // which is 0 + 2 + 1 since there must be a 2 sec gap between the two processes.
                    q.add(new int[] { remaining - 1, time + n + 1 });
                }
            }

            time++;
        }

        return time;
    }
}
