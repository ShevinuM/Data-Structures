class Solution1:
    # This was my initial approach to this problem before i realized HashMaps could solve this
    # This is generally an inefficient algorithm with a time complexity of O(n^2)
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        sumSet = set()
        for count in range(len(nums)):
            for index in range(len(nums)):
                if count == index:
                    continue
                else:
                    sum = nums[count] + nums[index]
                    if sum == target:
                        return [count, index]
                    else:
                        index+=1
            count+=1
    
    def test(self, nums, target):
        print()
        print("nums = {0}, target = {1}".format(nums, target))
        print("______________________________________")
        print(self.twoSum(nums,target))
        print()

solution1 = Solution1()
solution1.test([2,7,11,15],9)
solution1.test([3,2,4],6)
solution1.test([3,3], 6)


class Solution2:
    # this is my updated solution which uses HashMaps and cuts down the time-complexity to O(n)
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        numsMap = {}
        for count in range(len(nums)):
            toFind = target - nums[count]
            if toFind in numsMap:
                return [count, numsMap[toFind]]
            else:
                numsMap[nums[count]] = count
    
    def test(self, nums, target):
        print()
        print("nums = {0}, target = {1}".format(nums, target))
        print("______________________________________")
        print(self.twoSum(nums, target))
        print()

solution2 = Solution2()
solution2.test([2,7,11,15],9)
solution2.test([3,2,4],6)
solution2.test([3,3], 6)
