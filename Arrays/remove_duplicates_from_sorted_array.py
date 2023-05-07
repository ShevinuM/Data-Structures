'''
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.
'''

# This was my initial approach with a time complexity of O(n^2)
def removeDuplicates(nums: List[int]) -> int:
    for count in range(len(nums)):
        while True:
            if (count+1 < len(nums)) and (nums[count] == nums[count+1]):
                nums.pop(count+1)
            else:
                break
    return len(nums)

# This is my second approach with a time complexity of O(n)
def removeDuplicates(self, nums: List[int]) -> int:
    l, r = 0, 0
    num_length = len(nums)
    while l < num_length:
        if nums[l] == nums[r]:
            l = l + 1
        else:
            nums[r+1] = nums[l]
            r = r + 1
    return r+1