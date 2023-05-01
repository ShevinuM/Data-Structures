# this is my updated solution which uses HashMaps and cuts down the time-complexity to O(n)

def twoSum(nums, target):
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