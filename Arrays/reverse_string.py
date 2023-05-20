'''
Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.
'''
class Solution:
    def reverseString(self, s):
        """
        Do not return anything, modify s in-place instead.
        """
        index, len_s = 0, len(s)
        while (index != (len_s-1)-index and len_s%2 != 0) or (index+1 <= (len_s-1)-index and len_s%2 == 0):
            temp = s[index]
            s[index], s[len_s-1-index] = s[len_s-1-index], temp
            index+=1

    