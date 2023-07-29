/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * 
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
 * This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 * 
 * Example 1:
 * 
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * 
 * Example 2:
 * 
 * Input: root = [1,2]
 * Output: 1
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 104].
 * -100 <= Node.val <= 100
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
    /*
     * Brute Force O(n^2) solution. For each node, I calculate the max depth of the left and right subtrees and add them.
     * I keep track of the max value and return it.
     */
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // Diameter is equal to max depth from left + max depth from right
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.addLast(root);
        TreeNode curr;
        int val;
        while (!dq.isEmpty()) {
            curr = dq.removeFirst();
            val = maxDepth(curr.left) + maxDepth(curr.right);
            if (val > max) { max = val; }
            if (curr.left != null) { dq.addLast(curr.left); }
            if (curr.right != null) { dq.addLast(curr.right); }
        }
        return max;
        
    }

    public int maxDepth(TreeNode node) {
        if (node == null) { return 0; }
        if (node.left == null && node.right == null) { return 1; } 
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));      
    }
}

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
class Solution2 {
    /*
     * Optimal O(n) Time Complexity Solution. For each node, I calculate the max depth of the left and right subtrees and
     * add them. I keep track of the max value and return it.
     */
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // Diameter is equal to max depth from left + max depth from right
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode node) {
        if (node == null) { return 0; }
        int leftHeight = maxDepth(node.left);
        int rightHeight = maxDepth(node.right);
        max = Math.max(max, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);    
    }
}
