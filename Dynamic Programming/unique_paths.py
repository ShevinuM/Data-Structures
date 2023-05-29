'''
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.
'''

# My solution uses Dynamic Programming and Memoization. It uses a dfs recursive formula to calculate the number of unique paths from the top left corner to the bottom right corner. Once a path is identified it is stored in a dictionary (hashmap) so when that path is 
# encountered again, we don't have to recalculate.
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        path_map = {}
        def move(r, b, m, n):
            # base case
            if r == m - 1 and b == n - 1: return 1
            
            path = (r, b)
            if path in path_map: return path_map[path]
            elif r == m - 1: path_map[path] = move(r, b + 1, m, n)
            elif b == n - 1: path_map[path] = move(r + 1, b, m, n)
            else: path_map[path] = move(r + 1, b, m, n) + move(r, b + 1, m, n)
            return path_map[path]
        
        return move(0, 0, m, n)