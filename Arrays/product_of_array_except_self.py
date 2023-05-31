'''
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.
'''

class Solution:
    def productExceptSelf(self, nums):
        '''For this problem, we can make use of the fact that the Output[i]
        will be filled with the product of all the elements before nums[i] in
        the list and all the elements after nums[i] in the list. To do this,
            1. We can first create an empty output array.
            2. Run through nums and Output[i] = nums[i-1]*Output[i-1] if i > 0
            else Output[i] = 1. What this basically does is loading the output
            array with the sum of the numbers before nums[i]
            3. Run through nums again in reverse order. We maintain a variable
            called curr which contains the product of values after nums[i+1].
            We multiply the curr with res[i] to get the final output'''
        
        res = [0]*len(nums)
        curr = 1
        for count in range(len(nums)):
            res[count] = nums[count-1]*res[count-1] if count > 0 else 1
        for count in range(len(nums)-1, -1, -1):
            curr = curr * nums[count+1] if count < len(nums)-1 else 1
            res[count] = curr*res[count] if count < len(nums)-1 else res[count]
        return res
    
    def test(self, nums):
        print("{0} -> {1}".format(nums, self.productExceptSelf(nums)))

sol = Solution()
sol.test([1,2,3,4])
sol.test([-1,1,0,-3,3])
sol.test([1,2,3,4,5,6,7,8,9,10])
sol.test([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15])