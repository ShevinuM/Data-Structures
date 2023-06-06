import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue data structure in java is based on a minHeap.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num: nums) {
            // This operation runs n times
            minHeap.add(num);
            if (minHeap.size() > k) {
                /**
                .poll() removes the smallest (top) element of the minHeap
                This operation runs log(k) times since the height of a heap is log(k)
                 */
                minHeap.poll(); 
            }
        }
        /**
        .peek() lets us look at the smallest (top) element of the minHeap without removing
        This operation runs log(k) times since the height of the heap is log(k)
         */
        return minHeap.peek(); 
    }
}