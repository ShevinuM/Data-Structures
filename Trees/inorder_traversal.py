'''
Given the root of a binary tree, return the inorder traversal of its nodes' values.
'''

# Initial solution using recursion. Only requires 1 line of code
def inorder(root): return inorder(root.left) + [root.val] + inorder(root.right) if root else []

# Alternative solution using iteration
def inorderTraversal(root):
        stack = []
        curr = root
        res = []
        while curr or stack:
            while curr:
                stack.append(curr)
                curr = curr.left
            curr = stack.pop()
            res.append(curr.val)
            curr = curr.right
        return res