/**
 * You are playing a game involving a circular array of non-zero integers nums.
 * Each nums[i] denotes the number of indices forward/backward you must move if
 * you are located at index i:
 * 
 * - If nums[i] is positive, move nums[i] steps forward.
 * - If nums[i] is negative, move nums[i] steps backward.
 * 
 * Since the array is circular, you may assume that moving forward from the last
 * element
 * puts you on the first element, and moving backwards from the first element
 * puts you on the last element.
 * 
 * A cycle in the array consists of a sequence of indices seq of length k where:
 * 
 * 1. Following the movement rules above results in the repeating index sequence
 * seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
 * 2. Every nums[seq[j]] is either all positive or all negative.
 * 3. k > 1
 * 
 * Return true if there is a cycle in nums, or false otherwise.
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 * nums[i] != 0
 * 
 * Follow up: Could you solve it in O(n) time complexity and O(1) extra space
 * complexity?
 */

class Solution1 {
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int slow = i;
            int fast = i;
            boolean isForward = nums[slow] > 0;
            do {
                slow = getNextIndex(slow, nums, isForward);
                fast = getNextIndex(fast, nums, isForward);
                if (fast != -1)
                    fast = getNextIndex(fast, nums, isForward);
            } while (fast != -1 && slow != -1 && fast != slow);

            if (slow != -1 && slow == fast) {
                return true;
            }
        }
        return false;
    }

    public int getNextIndex(int pointer, int[] nums, boolean isForward) {
        boolean direction = nums[pointer] > 0;
        if (isForward != direction) {
            return -1;
        }
        int toReturn = (nums[pointer] + pointer + nums.length + nums.length) % nums.length;
        // checks if it's a self loop
        if (pointer == toReturn) {
            return -1;
        }
        return toReturn;
    }
}

// A more efficient solution in terms of time complexity. O(n^2) -> O(n).
// However less efficient in terms of space complexity. We use a HashSet to keep
// track of the visited indices.
class Solution2 {
    public boolean circularArrayLoop(int[] nums) {
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(i)) {
                continue;
            }
            int slow = i;
            int fast = i;
            boolean isForward = nums[slow] > 0;
            do {
                slow = getNextIndex(slow, nums, isForward);
                fast = getNextIndex(fast, nums, isForward);
                if (fast != -1)
                    fast = getNextIndex(fast, nums, isForward);
                visited.add(slow);
                visited.add(fast);
            } while (fast != -1 && slow != -1 && fast != slow);

            if (slow != -1 && slow == fast) {
                return true;
            }
        }
        return false;
    }

    public int getNextIndex(int pointer, int[] nums, boolean isForward) {
        boolean direction = nums[pointer] > 0;
        if (isForward != direction) {
            return -1;
        }
        int toReturn = (nums[pointer] + pointer) % nums.length;
        while (toReturn < 0) {
            toReturn = (toReturn + nums.length) % nums.length;
        }

        // checks if it's a self loop
        if (pointer == toReturn) {
            return -1;
        }

        return toReturn;
    }
}
