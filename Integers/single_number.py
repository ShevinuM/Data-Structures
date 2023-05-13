'''
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.
'''
from functools import reduce
def singleNumber(nums): return reduce(lambda x, y: x ^ y, nums)

def test(nums):
    print("Input: nums = {0} \n"
          "Output: {1}".format(nums, singleNumber(nums)))
test([2,2,1])
test([4,1,2,1,2])
test([1])