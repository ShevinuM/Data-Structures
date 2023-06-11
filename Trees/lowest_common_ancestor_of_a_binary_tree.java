/**
* Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
* According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest * node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

* Example 1:
* Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
* Output: 3
* Explanation: The LCA of nodes 5 and 1 is 3.
*
* Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
* Output: 5
* Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
*
* Input: root = [1,2], p = 1, q = 2
* Output: 1
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
    * Suppose we want to do Example 1:
    * We start at 3 and go to the left side of the tree. Each time, we compare the root node to see
    * if it's equal to either p or q, if so we return that node. So in this case, Since 5 which is the
    * left child is equal to p, we return 5 and left will be equal to 5. Then we go to the right side
    * and continue our search. Since 1 is equal to q, we return 1. Since both left and right are 
    * not null in this case, we return root.

    * Let's say we want to search for 6 and 4. We traverse the left side until we reach 6, we now
    * return 6 and left value when root = 5 will be 6, then we traverse the right side of 5 and the
    * right value when root = 2 will be 4. 
    * if (left != null) {
    *     return left;
    * } else {
    *     return right;
    * }
    * Based on this since left == null, we return 4 and hence the right value when root =5 will be
    * 4. Since both left and right are not null, we return 5. Then the left value when root = 3, 
    * will be 5 and afterwards, we return 5. 
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) { 
        if (root == null) {return null;}
        if (root == p|| root == q) {return root;}
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {return root;}
        if (left == null && right == null) {return null;} 

        if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}