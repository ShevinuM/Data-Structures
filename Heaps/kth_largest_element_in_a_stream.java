/*
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

The class should support the following operations:

- KthLargest(int k, int[] nums): Initializes the object with the integer k and the stream of integers nums.
- int add(int val): Appends the integer val to the stream and returns the element representing the kth largest element in the stream.

Example:

KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8

Constraints:

1. 1 <= k <= 10^4
2. 0 <= nums.length <= 10^4
3. -10^4 <= nums[i] <= 10^4
4. -10^4 <= val <= 10^4
5. At most 10^4 calls will be made to add.
6. It is guaranteed that there will be at least k elements in the array when you search for the kth element.
*/

class KthLargest1 {
    /*
     * Brute force approach: Add the elements to an ArrayList, sort the arraylist and iterate the arraylist to find the kth
     * element and return it.
     */
    ArrayList<Integer> nums = new ArrayList<>();
    int k;

    public KthLargest(int k, int[] nums) {
        for (int num : nums) {
            this.nums.add(num);
        }
        Collections.sort(this.nums, Comparator.reverseOrder());
        this.k = k;
    }
    
    public int add(int val) {
        this.nums.add(val);
        Collections.sort(this.nums, Comparator.reverseOrder());
        int index = 0;
        while (index < nums.size() && index < this.k-1) {
            index++;
        }
        return nums.get(index);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

class KthLargest2 {
    /*
     * Optimized solution using a minHeap. Add all the elements to the minHeap and remove the smallest element if the size
     * of the minHeap is greater than k. Return the top element of the minHeap. This is the kth largest element.
     */
    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
       this.minHeap = new PriorityQueue<>();
       for (int num : nums) { this.minHeap.offer(num); }
       this.k = k;
    }
    
    public int add(int val) {
        this.minHeap.offer(val);
        while (this.minHeap.size() > this.k) { this.minHeap.poll(); }
        return this.minHeap.peek();
    }
}