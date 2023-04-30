from solution import *

# Print linked-list
def print_linked_list(list):
    while list:
        print(list.val, end="->") if list.next is not None else print(list.val)
        list = list.next

# Case 1
# Create l1
l1 = ListNode(2)
l1.next = ListNode(4)
l1.next.next = ListNode(3)
# Create l2
l2 = ListNode(5)
l2.next = ListNode(6)
l2.next.next = ListNode(4)
# add Two Numbers
solution = Solution.addTwoNumbers(l1,l2)
print_linked_list(solution)

# Case 2
l1 = ListNode(0)
l2 = ListNode(0)
print_linked_list(Solution.addTwoNumbers(l1,l2))


