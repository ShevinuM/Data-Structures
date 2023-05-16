'''
Given the head of a singly linked list, reverse the list, and return the reversed list.
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head):
        if not head:
            return None
        head_prev, head, head_next = None, head, head.next
        while head:
            head.next= head_prev
            head_prev = head
            head = head_next
            if head:
                head_next = head.next
            else:
                return head_prev