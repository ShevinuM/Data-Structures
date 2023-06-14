/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary 
 * tree has the following definition:
 * 
 * struct Node {
 *  int val;
 *  Node *left;
 *  Node *right;
 *  Node *next;
 * }
 * 
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be 
 * set to NULL. Initially, all next pointers are set to NULL.
 * 
 * Example:
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to
 * its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers
 * with '#' signifying the end of each level.
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

class Solution {
    /**
     * For this problem I'm using bfs using a deque. I add the root to the queue and then I remove the first element
     * from the queue. If the queue is empty, I set the next pointer to null and add the left and right children to the
     * end of the queue. If the queue is not empty, I get the length of the queue which is equal to the number of elements
     * in the current level - 1 (since I removed 1 element from the queue). I then iterate through the queue until all the 
     * elements in the current level have been removed. I set the next pointer to the next element in the queue. 
     * Finally I add the last element's children to the end of the queue.
     */
    public Node connect(Node root) {
        Deque<Node> q = new ArrayDeque<>();
        Node node;
        Node node2;
        if (root == null) { return root; }
        q.addLast(root);
        while (!q.isEmpty()) {
            node = q.removeFirst();
            if (q.isEmpty()) {
                node.next = null;
                if (node.left != null) { q.addLast(node.left); }
                if (node.right != null) { q.addLast(node.right); }
            } else {
                int qlen = q.size();
                for (int count = 0; count < qlen; count++ ) {
                    node2 = q.removeFirst();
                    if (node.left != null) { q.addLast(node.left); }
                    if (node.right != null) { q.addLast(node.right); }
                    node.next = node2;
                    node = node2;
                }
                if (node.left != null) { q.addLast(node.left); }
                if (node.right != null) { q.addLast(node.right); }
            }
        }
        return root;
    }
}


