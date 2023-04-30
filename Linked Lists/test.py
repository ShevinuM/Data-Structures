from main import *

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