'''
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
'''

# This was my initial solution with a time complexity of O(n) and a space complexity of O(n).
class Solution:
    def missingNumber(self, nums) -> int:
        max = 0
        arr = []
        for num in nums:
            if num >= max:
                max = num
        arr = [-1]*(max+1)
        for num in nums: arr[num] = num
        count = 0
        while count < len(arr):
            if arr[count] == -1:
                return count
            count += 1
        return count
    
    def test(self, nums):
        print("The missing number in {0} is {1}.".format(nums, Solution.missingNumber(nums)))

sol = Solution()
sol.test([3,0,1])
sol.test([0,1])
sol.test([9,6,4,2,3,5,7,0,1])
sol.test([0])
