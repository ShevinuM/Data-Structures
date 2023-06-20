/*
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path 
such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.

Example 2:
Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.

Example 3:
Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.

Constraints:
The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
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
     * For this solution I'm using dfs using recursion. In each call i subtract the value of the node from the target sum 
     * and once we reach the point where the node is a leaf node and the target sum is 0, i return true.
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) { return false; }
        int sum = targetSum - root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.right, sum) || hasPathSum(root.left, sum);
    }
}