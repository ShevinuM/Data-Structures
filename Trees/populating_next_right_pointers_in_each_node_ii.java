/**
 * Given a binary tree like the structure below
 *
 *  class Node {
 *      int val;
 *      Node left;
 *      Node right;
 *      Node next;
 *  }
 * 
 * The task is to populate each 'next' pointer to point to its next right node. If there is no next right node, 
 * the 'next' pointer should be set to NULL.
 *
 * Initially, all 'next' pointers are set to NULL.
 * 
 * Examples:
 * 
 * 1. Input: root = [1,2,3,4,5,null,7]
 *    Output: [1,#,2,3,#,4,5,7,#]
 *    Explanation: Given the above binary tree, your function should populate each next pointer to point to 
 *    its next right node. The serialized output is in level order as connected by the next pointers, 
 *    with '#' signifying the end of each level.
 *
 * 2. Input: root = []
 *    Output: []
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [0, 6000].
 * -100 <= Node.val <= 100
 */

 /*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

/*
 * This solution uses two deques. One deque keeps tracks of nodes of the current level and the other keeps track of the 
 * children. Iterating over the deque of the current level, I add the children to the deque of children. If the deque of
 * the current level is empty, I set the next pointer to null and add the children to the deque of the current level.
 * Otherwise, I set the next pointer to the first element in the deque of the current level.
 */
class Solution {
    public Node connect(Node root) {
        if (root == null) { return root; }
        Node dummy = new Node();
        dummy.next = root;
        Deque<Node> dq = new ArrayDeque<>();
        Deque<Node> children = new ArrayDeque<>();
        Node curr;
        dq.addLast(root);
        while (!dq.isEmpty()) {
            curr = dq.removeFirst();
            if (curr.left != null) { children.addLast(curr.left); }
            if (curr.right != null) { children.addLast(curr.right); }
            while (dq.peekFirst() == null && !dq.isEmpty()) {
                dq.removeFirst();
            }
            if (dq.isEmpty()) {
                curr.next = null;
                dq.addAll(children);
                children.clear();
            } else {
                curr.next = dq.peekFirst();
            }
        }
        return dummy.next;
    }
}