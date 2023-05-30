'''
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# For this solution, we are using a deque which contains tuples. Each tuple contains the node and the level. The index of the res array
# corresponds to the level. res array consists of sub arrays for each level. We add the node to the corresponding subarray. We then 
# proceed to add left and right nodes to the queue. When the queue is empty, all the nodes have been vistied and hence we return res.
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: return []
        res = []
        queue = deque()
        queue.append((root, 0))
        while queue:
            node, level = queue.popleft()
            if level == len(res): res.append([])
            res[level].append(node.val)

            if node.left: queue.append((node.left, level + 1))
            if node.right: queue.append((node.right, level + 1))
        
        return res