class Solution:
    def reverseBits(self, n: int) -> int:
        res = 0
        for count in range(32):
            bit = (n >> count) & 1
            res = (res << 1) | bit
        return res