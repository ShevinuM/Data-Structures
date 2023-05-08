'''
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.
'''

#Time-Complexity O(n), Space Complexity O(1)
def plusOne(digits):
    index = 1
    while True:
        if index <= len(digits) and digits[-index] + 1 < 10 :
            digits[-index] = digits[-index] + 1
            break
        elif index > len(digits):
            digits.insert(0, 1)
            break
        else:
            digits[-index] = 0
            index+=1
    return digits
