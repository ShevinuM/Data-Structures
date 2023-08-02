/*
You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

- If x == y, both stones are destroyed, and
- If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.

At the end of the game, there is at most one stone left. Return the weight of the last remaining stone. If there are no stones left, return 0.

Example 1:

Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation: 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.

Example 2:

Input: stones = [1]
Output: 1

Constraints:

- 1 <= stones.length <= 30
- 1 <= stones[i] <= 1000
*/

class Solution {
    /*
     * This problem can be easily solved by using a priority queue. We use a priority queue which maintains priority in
     * descending order. We add all the stones to the priority queue. Then we keep removing the top two elements from
     * the priority queue and add the difference of the two elements to the priority queue if the stones are not equal. 
     * We keep doing this until the priority queue has only one element or less left. If the priority queue is empty, we 
     * return 0 else we return the last remaining element.
     * 
     * Time Complexity: O(nlogn) where n is the number of stones.
     */
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0) { return 0; }
        int stone1, stone2;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) { q.add(stone); }
        while (q.size() > 1) {
            stone2 = q.poll();
            stone1 = q.poll();
            if (stone1 != stone2) { q.add(stone2 - stone1); }
        }
        return q.size() > 0 ? q.poll() : 0;
    }
}