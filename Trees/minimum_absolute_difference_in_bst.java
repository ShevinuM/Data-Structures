/**
 * Given the root of a Binary Search Tree (BST), this function returns the minimum absolute difference
 * between the values of any two different nodes in the tree.
 *
 * Example 1:
 * Input: root = [4,2,6,1,3]
 * Output: 1
 *
 * Example 2:
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 *
 * The method performs an in-order traversal of the BST. Since an in-order traversal of a BST
 * gives a sorted sequence, the minimum absolute difference is to be found among adjacent elements.
 * The function also keeps track of the previously visited node in the traversal to compare it
 * with the current node.
 *
 * Constraints:
 * The number of nodes in the tree is in the range [2, 104].
 * 0 <= Node.val <= 105
 *
 * @param root - The root node of the BST
 * @return The minimum absolute difference between the values of any two different nodes in the tree
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
     * For this solution, I'm using inorder traversal of the BST. Since an inorder traversal of a BST gives a sorted sequence,
     * the minimum absolute difference is to be found among adjacent elements. The function also keeps track of the previously
     * visited node in the traversal to calculate the difference.
     */
    int prev = Integer.MAX_VALUE;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
       inOrder(root);
       return min;
    }

    public void inOrder(TreeNode root) {
        if (root.left != null) { inOrder(root.left); }
        min = Math.min(min, Math.abs(root.val-prev));
        prev = root.val;
        if (root.right != null) { inOrder(root.right); }
    }
}
