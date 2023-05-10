'''
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n. 
'''

def merge(nums1, m, nums2, n):
    last = m + n - 1
    while m > 0 and n > 0:
        if nums1[m-1] > nums2[n-1]:
            nums1[last] = nums1[m-1]
            m-=1
        else:
            nums1[last] = nums2[n-1]
            n-=1
        last-=1
    while n > 0:
        nums1[last] = nums2[n-1]
        last-=1
        n-=1

    return nums1 # Just for the purposes of showing that my code works I'm returning nums1

def Test():
    print("nums1 = [1,2,3,0,0,0], "
          "m = 3, "
          "nums2 = [2,5,6], "
          "n = 3, "
          "Output: {}".format(merge(nums1=[1],m= 1,nums2=[],n = 0)))
    print("nums1 = [1,2,3,0,0,0], " 
          "m = 3, "
          "nums2 = [2,5,6], "
          "n = 3, "
          "Output: {}".format(merge(nums1=[1,2,3,0,0,0],m = 3,nums2 = [2,5,6], n = 3)))
    print("nums1 = [0], " 
          "m = 0, "
          "nums2 = [1], "
          "n = 1, "
          "Output: {}".format(merge(nums1=[0],m=0,nums2=[1],n=1)))

Test()
    
