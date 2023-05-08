'''

Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

'''

# This was my initial solution to this problem
import math


def mySqrt(x: int) -> int:
    x_half = x//2
    if x == 1:
        return 1
    if x == 0:
        return 0
    for count in range(1, x_half+1):
        if (count+1) * (count+1) > x:
            return count
        else:
            continue

# This wa my second approach with a O(logn) time complexity which is more efficient
def mySqrt(self, x: int) -> int:
    l, r = 0, x

    while True:
        mid = (l + r)/2
        if mid * mid > x:
            r = mid
        elif mid * mid < x:
            l = mid
            if math.floor(mid)*math.floor(mid) < x < math.ceil(mid)*math.ceil(mid):
                return math.floor(mid)
        elif mid * mid == x:
            return int(mid)