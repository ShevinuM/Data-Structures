class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def mergeTwoLists(list1, list2):
        curr = ListNode()
        toReturn = curr
        while list1 != None and list2 != None:
            if list1.val < list2.val:
                curr.next = list1
                list1 = list1.next
            elif list2.val <= list1.val:
                curr.next = list2
                list2 = list2.next
            curr = curr.next
        curr.next = list1 if list1 != None else list2
        return toReturn.next