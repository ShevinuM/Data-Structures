'''
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
'''

# Recursive solution to the problem
def maxDepth(root):
    def depth(root):
        if root is None:
            return 0
        if root.left is None and root.right is None:
            return 1
        if root.left or root.right:
            return 1 + max(depth(root.left), depth(root.right))
    return depth(root)

# Iterative solution to the problem
def maxDepth2(root):
    if not root:
        return 0
    stack = [[root,1]]
    max_depth = 1
    while stack:
        [node, position] =  stack.pop()
        if node.right or node.left:
            max_depth = position+1 if position+1>max_depth else max_depth
            if node.right:
                stack.append([node.right,position+1])
            if node.left:
                stack.append([node.left,position+1])
    return max_depth

    
