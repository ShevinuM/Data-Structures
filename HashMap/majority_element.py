'''
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
'''

class Solution:
    def majorityElement(self, nums):
        nums_map = {}
        for num in nums:
            nums_map[num] = nums_map[num]+1 if num in nums_map else 1
        return max(nums_map, key=nums_map.get)
    
    def test(self, nums):
        print()
        print("nums = {0}, Output = {1}".format(nums, self.majorityElement(nums)))

sol = Solution()
sol.test([3,2,3])
sol.test([2,2,1,1,1,2,2])
print()