'''
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.
'''
# This solution has a time complexity of O(n^2) and a space complexity of O(1)
class Solution:
    def moveZeroes(self, nums) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        zeros, count = 0, 0
        for num in nums: zeros = zeros + 1 if num == 0 else zeros
        while zeros > 0:
            if nums[count] == 0:
                zeros-=1
                for index in range(count, len(nums)-1): nums[index] = nums[index+1]
                nums[-1] = 0
            else:
                count+=1
