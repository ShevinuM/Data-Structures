''''
Given an integer array nums where the elements are sorted in ascending order, convert it to a
height-balanced binary search tree.
'''
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
def sortedArrayToBST(nums: List[int]) -> Optional[TreeNode]:
    def makeTree(l,r):
        if l>r:
            return None
        mid = (l + r) // 2
        node = TreeNode(nums[mid])
        node.right = makeTree(mid+1, r)
        node.left = makeTree(l, mid-1)
        return node
    return makeTree(0,len(nums)-1)