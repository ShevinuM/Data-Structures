# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

# You are given two non-empty linked lists representing two non-negative integers.
# The digits are stored in reverse order, and each of their nodes contains a single digit.
# Add the two numbers and return the sum as a linked list.
#You may assume the two numbers do not contain any leading zero, except the number 0 itself.

class Solution():
    def addTwoNumbers(l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        
        # Take the values in each of the nodes and add them along with the carry
        # Add the result to another ListNode
        # return the new list node

        carry = 0
        return_list = ListNode()
        curr = return_list
        l1 = l1 if l1 else l1.next
        l2 = l2 if l2 else l2.next

        while l1 or l2:
            l1_value = l1.val if l1 else 0
            l2_value = l2.val if l2 else 0
            result = l1_value + l2_value + carry

            carry = result//10
            value = result %10
            curr.next = ListNode(value)

            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
            curr =  curr.next
        
        result = carry if carry > 0 else None
        curr.next = ListNode(result) if result else None

        return return_list.next