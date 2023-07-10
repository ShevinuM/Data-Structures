/**
 * Given the root of a complete binary tree, the task is to return the number of the nodes in the tree.
 *
 * According to Wikipedia, a complete binary tree is a binary tree in which every level, 
 * except possibly the last, is completely filled, and all nodes in the last level are as 
 * far left as possible. It can have between 1 and 2^h nodes inclusive at the last level h.
 *
 * Design an algorithm that runs in less than O(n) time complexity.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5,6]
 * Output: 6
 *
 * Example 2:
 * Input: root = []
 * Output: 0
 *
 * Example 3:
 * Input: root = [1]
 * Output: 1
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 5 * 10^4].
 * 0 <= Node.val <= 5 * 10^4
 * The tree is guaranteed to be complete.
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
     * In this solution i compare the height of the left sub tree and the right sub tree. If they are equal that means the left sub 
     * tree is a full binary tree. I then recursively add the number of nodes in the left sub tree and the number of nodes in the
     * right sub tree and 1. If the heights are not equal, i count the nodes for each subtree and recursively add them.
     */
    public int countNodes(TreeNode root) {
        if (root == null) { return 0; }
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (leftHeight == rightHeight) {
            return 1 + countNodesOfTree(root.left) + countNodes(root.right);
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    public int getHeight(TreeNode root) {
        if (root == null) { return 0; }
        int count = 0;
        while (root.left != null) {
            root = root.left;
            count++;
        }
        return count;
    }

    public int countNodesOfTree(TreeNode root) {
        if (root == null) { return 0; }
        int branch_height = getHeight(root);
        int total = 0;
        for (int count = 0; count <= branch_height; count++) {
            total = total + (int) Math.pow(2, count);
        }
        return total;
    }
}
