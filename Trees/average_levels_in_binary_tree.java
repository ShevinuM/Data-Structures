/**
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
 * Answers within 10^-5 of the actual answer will be accepted.
 *
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
 * Hence return [3, 14.5, 11].
 *
 * Example 2:
 *
 * Input: root = [3,9,20,15,7]
 * Output: [3.00000,14.50000,11.00000]
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 10^4].
 * -2^31 <= Node.val <= 2^31 - 1
 */
class Solution {
    /*
     * For this solution I'm using bfs using a deque. Since the size of the current q is equal to the number of 
     * nodes of that particular level, I make use of this and use that to calculate the sum for each level Then 
     * after iterating over the level, I calculate the average and add it to the list.
     */
    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        List<Double> avgs = new ArrayList<>();
        TreeNode curr;
        int size;
        double sum; // prevent integer overflowing
        q.addFirst(root);
        while (!q.isEmpty()){
            size = q.size();
            sum = 0;
            for (int index = 0; index < size; index++) {
                curr = q.removeLast();
                sum += curr.val;
                if (curr.left != null) {q.addFirst(curr.left); }
                if (curr.right != null) {q.addFirst(curr.right); }
            }
            avgs.add((double) sum/size);
        }
        return avgs;
    }
}

