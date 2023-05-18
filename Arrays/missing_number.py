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
        print("The missing number in {0} is {1}.".format(nums, self.missingNumber(nums)))

sol = Solution()
print("Test for Solution 1:")
sol.test([3,0,1])
sol.test([0,1])
sol.test([9,6,4,2,3,5,7,0,1])
sol.test([0])


# This is a more efficient solution with a time complexity of O(n) and a space complexity of O(1).
class Solution2:
    def missingNumber(self, nums) -> int:
        max, result, found = 0, 0, False
        for num in nums:
            if num == 0:
                found = True
            if num >= max:
                max = num
            result = result ^ num
        for count in range(0, max+1): result = result ^ count
        return max + 1 if result == 0 and found else result

    def test(self, nums):
        print("The missing number in {0} is {1}.".format(nums, self.missingNumber(nums)))

sol2 = Solution2()
print("Test for Solution 2:")
sol2.test([3,0,1])
sol2.test([0,1])
sol2.test([9,6,4,2,3,5,7,0,1])
sol2.test([0])
sol2.test([1])

# This is an even more efficient solution with a time complexity of O(n) and a space complexity of O(1) using Gauss's Formula.
class Solution3:
    def missingNumber(self, nums) -> int:
        n = len(nums) 
        sum = (n * (n+1)) // 2 # Gauss's formula
        for num in nums: sum = sum - num
        return sum
    
    def test(self, nums):
        print("The missing number in {0} is {1}.".format(nums, self.missingNumber(nums)))

sol3 = Solution3()
print("Test for Solution 3:")
sol3.test([3,0,1])
sol3.test([0,1])
sol3.test([9,6,4,2,3,5,7,0,1])
sol3.test([0])

