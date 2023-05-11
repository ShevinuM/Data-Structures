'''
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
'''

def maxDepth(root):
    def depth(root):
        if root is None:
            return 0
        if root.left is None and root.right is None:
            return 1
        if root.left or root.right:
            return 1 + max(depth(root.left), depth(root.right))
    return depth(root)
