'''

Given the root of a binary tree, return the inorder traversal of its nodes' values.

'''

# Initial solution using recursion only requires 1 line of code
def inorder(root): return inorder(root.left) + [root.val] + inorder(root.right) if root else []

