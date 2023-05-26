'''
Given the head of a linked list, remove the nth node from the end of the list and return its head.
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

'''
This is my first solution to the problem. It first iterates through the list to
calculate the length of the list. Then from the length we determine the index to be
removed. Then we iterate through the list again to remove the node at the index.
'''
class Solution:
    def removeNthFromEnd(self, head, n: int):
        length = self.lenLinkedList(head)
        index = length - n
        curr = head
        if n == length:
            prev = head
            head = head.next
            prev.next = None
        else:
            for count in range(index):
                prev = curr
                nex = curr.next.next
                curr = curr.next
            prev.next = nex
            curr.next = None
        return head
    
    def lenLinkedList(self, head):
        n = 0
        while head:
            n += 1
            head = head.next
        return n