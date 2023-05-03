import math

class Solution:
    # This was my initial solution to this problem using strings
    def reverse1(x: int) -> int:
        if x < 0:
            negative = True
            x = -x
        else:
            negative = False
        string = str(x)
        new_string = ""
        for character in string:
            new_string = character + new_string
        return_int = -int(new_string) if negative else int(new_string)
        if return_int >= -(2**31) and return_int <= (2**31) - 1:
            return return_int
        else:
            return 0
    
    # This is my second approach
    def reverse2(x: int) -> int:
        l = abs(x)
        r = abs(x) // 10 ** (len(str(abs(x))) - 1)
        val = 0
        while l > 9:
            val = (((l%10)/10)+val)*10
            l = l//10
            if val > 214748364:
                return 0
        if val == (214748364) and abs(l) > 7:
                return 0
        return int(val*10 + r) if x > 0 else int(-(val*10 + r))
    
class Test:
    print()
    print("Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the \nsigned 32-bit integer range [-231, 231 - 1], then return 0. Assume the environment does not allow you to store 64-bit \nintegers (signed or unsigned).")
    print("_____________________________________________________________________________________________________________________")
    print("1234 -> {}".format(Solution.reverse2(1234)))
    print()
    print("-123 -> {}".format(Solution.reverse2(-123)))
    print()
    print("120 -> {}".format(Solution.reverse2(120)))
    print()
    print("-1463847412 -> {}".format(Solution.reverse2(-1463847412)))
    print()

Test()

    