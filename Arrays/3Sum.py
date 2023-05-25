'''
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
'''

'''
I believe this solution is the most efficient solution for this problem. It uses a combination of TwoSum and TwoSumII. We sort the array and then iterate through it. After obtaining the first number we use TwoSumII to find the other two numbers. We use a while loop to skip over duplicate numbers. We also use a while loop to skip over duplicate triplets. The time complexity is O(n^2) and the space complexity is O(1).
'''
class Solution:
    def threeSum(self, nums):
        nums.sort()
        res = []
        for index, num in enumerate(nums):
            if index > 0 and nums[index-1] == num:
                continue
            else:
                l, r = index+1, len(nums)-1
                while l < r:
                    threeSum = num + nums[l] + nums[r]
                    if threeSum > 0:
                        r -= 1
                    elif threeSum < 0:
                        l += 1
                    else:
                        res.append([num, nums[l], nums[r]])
                        l +=1
                        while nums[l-1] == nums[l] and l < r:
                            l += 1
        return res
    
    def test(self, nums):
        print("Input: nums = {0}, Output: {1}".format(nums, self.threeSum(nums)))

sol = Solution()
sol.test([-1,0,1,2,-1,-4])
sol.test([0,0,0])
sol.test([0,0,0,0])
sol.test([-2,0,1,1,2])