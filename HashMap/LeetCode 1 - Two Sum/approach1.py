# This was my initial approach to this problem before i realized HashMaps could solve this
# This is generally an inefficient algorithm with a time complexity of O(n^2)
def twoSum(nums, target):
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