import java.util.ArrayList;

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
    
    // For our solution, we are recursively in-order traversing the BST. We make use of the fact that in a binary search tree,
    // elements are sorted in order with the left most element being the smallest and the right most element being the largest
    // So, the left element is always smaller than the element which is smaller than the right element.

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        traverse(root, inOrder);
        return inOrder.get(k-1);
    }

    public void traverse(TreeNode root, ArrayList<Integer> inOrder) {
        // Base Case
        if (root == null) {return;}
        traverse(root.left, inOrder);
        inOrder.add(root.val);
        traverse(root.right, inOrder);
    }
}
