'''
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    '''
    For this solution we use two pointers, an even pointer and an odd pointer. Both are shifted simultaneously
    updating the next pointers of each even and odd node to the correct next even or odd node. This results in 
    forming two seperate linked lists. The head of the even list is joined to the end of the odd list and the 
    head is returned
    '''
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next: return head
    
        curr_odd, curr_even, head_even = head, head.next, head.next

        while curr_odd.next and curr_odd.next.next:
            curr_odd.next = curr_odd.next.next
            curr_odd = curr_odd.next
            curr_even.next = curr_even.next.next
            curr_even = curr_even.next

        curr_odd.next = head_even
        if curr_even: curr_even.next = None
        return head