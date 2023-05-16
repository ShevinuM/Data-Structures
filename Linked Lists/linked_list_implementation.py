# Implementation of a Basic Linked List

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
    
class LinkedList:
    def __init__(self):
        self.head = None
    
    # inserts the node at the end of the linkedlist
    def insert_at_end(self, data):
        new_node = Node(data)
        if self.head is None:
            self.head = new_node
        else:
            current = self.head
            while current.next is not None:
                current = current.next
            current.next = new_node
    
    # inserts the node at the beginning of the linked list
    def insert_at_beginning(self, data):
        new_node = Node(data)
        if self.head is None:
            self.head = new_node
        else:
            current = self.head
            self.head = new_node
            self.head.next = current
    
    #inserts the node at a given index in the linked list. Index starts from 0
    def insert_at_index(self, data, index):
        if index<0 or index>=self.get_length():
            raise Exception("Invalid index")
        else:
            new_node = Node(data)
            count = 0
            if index==0:
                self.insert_at_beginning(data)
            elif index==self.get_length():
                self.insert_at_end(data)
            else:
                current = self.head
                next_next = current.next
                while current:
                    if count == index-1:
                        new_node.next = next_next
                        current.next = new_node
                        return
                    else:
                        current = current.next
                        next_next = current.next
                        count+=1
    
    #removes an element at a given index in the linked list
    def remove_from_index(self, index):
        if index<0 or index>=self.get_length():
            raise Exception("Invalid index")
        count = 0
        current = self.head
        if index==0:
            self.head = current.next
            current.next = None
        else:
            while count < index-1:
                current = current.next
                count+=1
        new_next = current.next.next
        current.next.next = None
        current.next = new_next
                

    #returns the length of the linked list
    def get_length(self):
        if self.head is None:
            return 0
        current = self.head
        count = 1
        while current.next is not None:
            count += 1
            current = current.next
        return count

    
    #prints the linked list
    def print_linked_list(self):
        current = self.head
        while current is not None:
            if current.next is not None:
                print(str(current.data), end="-->")
            else:
                print(str(current.data))
            current = current.next

class Test:
    my_list = LinkedList()

    print("Insert 5 At Beginning")
    my_list.insert_at_beginning(5)
    my_list.print_linked_list()
    print()

    print("Insert 8 At End")
    my_list.insert_at_end(8)
    my_list.print_linked_list()
    print()

    print("Insert 7 At Index 1")
    my_list.insert_at_index(7, 1)
    my_list.print_linked_list()
    print()

    print("Insert 4 At Beginning")
    my_list.insert_at_beginning(4)
    my_list.print_linked_list()
    print()

    print("Insert 6 At Index 2")
    my_list.insert_at_index(6, 2)
    my_list.print_linked_list()
    print()

    print("Remove element at index 2 (which is 6)")
    my_list.remove_from_index(2)
    my_list.print_linked_list()
    print()
