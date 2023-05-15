class Solution:
    def hammingWeight(self, n: int) -> int:
        if n == 0:
            return 0
        res, count = 0, 0
        while n >> count != 0:
            if (n >> count) & 1 == 1:
                res +=1
            count+=1
        return res