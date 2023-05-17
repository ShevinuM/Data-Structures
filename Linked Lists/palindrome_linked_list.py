'''
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# This solution has a time complexity and space complexity of O(n)
class Solution1:
    def isPalindrome(self, head) -> bool:
        head_arr = []
        while head:
            head_arr.append(head.val)
            head = head.next
        return True if head_arr == head_arr[::-1] else False

# This is the most efficient solution to this problem because it has a time complexity of O(n) while utilizing constant memory O(1)
class Solution:
    def isPalindrome(self, head) -> bool:
        slow, fast = head, head
        while fast and fast.next: fast, slow = fast.next.next, slow.next
        prev, nex = None, slow.next 
        while slow:
            slow.next = prev
            prev = slow
            slow = nex
            nex = None if not slow else slow.next
        slow = prev
        while slow and head:
            if slow.val != head.val:
                return False
            slow, head = slow.next, head.next
        return True