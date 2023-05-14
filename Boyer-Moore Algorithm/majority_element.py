'''
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
'''

# This is my second approach to this problem. Initially, I solved it using a hash-map which has O(n) space complexity.
# After I learnt about the Boyer-Moore algorithm I'm solving it using O(1) space complexity
class Solution:
    def majorityElement(self, nums):
        res, count = 0, 0
        for num in nums:
            res = num if count == 0 else res
            count = count + 1 if num == res else count - 1
        return res
    
    def test(self, nums):
        print()
        print("Input: {0}, Output: {1}".format(nums, self.majorityElement(nums)))

sol = Solution()
sol.test([3,2,3])
sol.test([2,2,1,1,1,2,2])