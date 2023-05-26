'''
Given the head of a linked list, remove the nth node from the end of the list and return its head.
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# This is my second solution to this problem and it is the most efficient solution. It has a time complexity of O(n) and a space complexity of O(1). 
class Solution2:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        # So in this case, we need to remove from the end by n places. So we can use a two pointer
        # technique. The second pointer will always be n+1 places ahead of the first pointer.
        # For example, if n = 2 and our linked list is [1,2,3,4,5], our first pointer is at 3 and our
        # second pointer is at None. This way, first.next = first.next.next can be done. 

        dummy = ListNode(None, head)
        first, second = dummy, head
        for count in range(n): second = second.next

        while second: first, second = first.next, second.next
        
        if first.next.next: first.next = first.next.next
        elif first.next: first.next = None
        return dummy.next


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