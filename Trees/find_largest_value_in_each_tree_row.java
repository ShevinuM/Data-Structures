/**
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 * 
 * Example 1:
 * Input: root = [1,3,2,5,3,null,9]
 * Output: [1,3,9]
 * 
 * Example 2:
 * Input: root = [1,2,3]
 * Output: [1,3]
 * 
 * Constraints:
 * The number of nodes in the tree will be in the range [0, 10^4].
 * -2^31 <= Node.val <= 2^31 - 1
 */

 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) { return new ArrayList<>(); }
        /*
            Deque of arrays where < [val, leve] >
            
            We use bfs to iterate
        */
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Object[]> dq = new ArrayDeque<>();
        dq.addLast(new Object[]{root, 0});
        
        Object[] item;
        TreeNode node;
        int level;
        while (!dq.isEmpty()) {
            item = dq.removeFirst();
            node = (TreeNode) item[0];
            level = (int) item[1];
            if (level > res.size() - 1) {
                res.add(node.val);
            } else {
                if (res.get(level) < node.val) { res.set(level, node.val); }
            }
            if (node.left != null) { dq.addLast(new Object[]{node.left, level+1}); }
            if (node.right != null) { dq.addLast(new Object[]{node.right, level+1}); }
        }
        return res;
    }
}

