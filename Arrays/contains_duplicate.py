'''
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
'''
class Solution:
    def containsDuplicate(self, nums) -> bool:
        nums_set = set()
        for num in nums:
            if num in nums_set:
                return True
            else:
                nums_set.add(num)
        return False

    def test(self, nums):
        toOutput = "contains" if self.containsDuplicate(nums) else "does not contain"
        print("The set {0}, {1} duplicates.".format(nums, toOutput))

sol = Solution()
sol.test([1,2,3,1])
sol.test([1,2,3,4])
sol.test([1,1,1,3,3,4,3,2,4,2])
