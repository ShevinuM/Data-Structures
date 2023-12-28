# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    # Add the value of each node to a list in order
    # Create a hashmap containing the value as the key and node as the value
    # Remove all the next pointers of the nodes
    # Have left and right pointers and carry on
    def reorderList(self, head):
        """
        Do not return anything, modify head in-place instead.
        """
        if head is None: return []
        curr = head
        lst = []
        while curr:
            lst.append(curr)
            curr = curr.next
        for node in lst:
            node.next = None
        
        l = 0
        r = len(lst) - 1
        start = lst[l]
        end = start
        while (l < r):
            end.next = lst[r]
            end = end.next
            l+=1
            end.next = lst[l]
            end = end.next
            r-=1
        end.next = None
        return start
