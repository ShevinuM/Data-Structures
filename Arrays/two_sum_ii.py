'''
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.
'''

class Solution:
    '''
    My solution uses two pointers. We have a left pointer and a right pointer. Since the array is sorted we can move the pointers until we find the target. We start with the left pointer at 0 and the right pointer at len(numbers)-1. We calculate the sum of the two numbers at the pointers. If the sum is greater than the target we decrement the right pointer. If the sum is less than the target we increment the left pointer. If the sum is equal to the target we return the pointers (1 is added because the return array is supposedly 1 indexed instead of 0 indexed).
    '''
    def twoSum(self, numbers, target: int):
        left, right = 0, len(numbers) - 1
        while left <= right:
            ans = numbers[left] + numbers[right]
            if ans > target:
                right -= 1
            if ans < target:
                left += 1
            if ans == target:
                return [left+1, right+1]
    
    def test(self, numbers, target):
        print("Input: numbers = {0}, target = {1}, Output: {2}".format(numbers, target, self.twoSum(numbers, target)))

sol = Solution()
sol.test([2,7,11,15], 9)
sol.test([2,3,4], 6)
sol.test([-1,0], -1)
sol.test([0,0,3,4], 0)
sol.test([5,25,75], 100)
sol.test([1,2,3,4,4,9,56,90], 8)