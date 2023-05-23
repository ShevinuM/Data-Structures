'''
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.
'''

class Solution:
    '''
    For my solution, I'm using a two pointer technique. We have two pointers left and right
    left is assigned to 0 and right is assigned to len(height)-1. So simply speaking, left
    is assigned to the left most height and right is assigned to the right most height.
    We use another variable called max_area to keep track of the max_area we encounter.
    we calculate the area by the formula min(height[left],height[right])*abs(right-left)
    if height[left] > height[right] we decrement the right pointer and vice verse.
    This is because we want to always maintain the maximum area.
    '''
    def maxArea(self, height) -> int:
        left, right, max_area = 0, len(height)-1, 0

        while left <= right:
            area = min(height[left],height[right])*abs(right-left)
            if height[left] > height[right]:
                right-=1
            else:
                left+=1
            max_area = area if area > max_area else max_area
        
        return max_area
    
    def test(self, height):
        print("Input: height = {0}, Output: {1}".format(height, self.maxArea(height)))

sol = Solution()
sol.test([1,8,6,2,5,4,8,3,7])
sol.test([1,1])
sol.test([4,3,2,1,4])
sol.test([1,2,1])