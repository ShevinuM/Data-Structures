class Solution:
    def missingNumber(nums) -> int:
        max = 0
        arr = []
        for num in nums:
            if num >= max:
                max = num
                while len(arr) != max+1:
                    arr.append(-1)
            arr[num] = num
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
