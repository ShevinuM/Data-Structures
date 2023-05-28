'''
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
'''

class Solution:
    # We do this problem by depth first search using recursion
    def permute(self, nums):
        result = []

        # We first define the base case.
        if (len(nums) == 1): return [nums[:]]
        
        for count in range(len(nums)):
            popped = nums.pop(0)
            arr = self.permute(nums)
            for p in arr: p.append(popped)
            result.extend(arr)
            nums.append(popped)
        
        return result
