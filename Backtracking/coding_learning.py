'''
Given an integer array nums of unique elements, return all possible 
subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
'''

# In this solution, we use an index to iterate over the array, we keep track of the current subset in an array called arr and then we 
# add that subset array to the result array and continue with a different index
class Solution:
    def subsets(self, nums):
        res = []
        arr = []
        def backtrack(index):
            if index >= len(nums):
                res.append(arr.copy())
                return

            # Case 2: subset containing nums[index]
            arr.append(nums[index])
            backtrack(index+1)

            # Case 3: subset not containing nums[index]
            arr.pop()
            backtrack(index+1)
        
        backtrack(0)
        return res
    
    def test(self, nums):
        print("Input: {0}, Output: {1}".format(nums, self.subsets(nums)))

sol = Solution()
sol.test([1,2,3])
sol.test([0])
sol.test([1,2])
sol.test([1,2,3,4,5,6,7,8,10,0])