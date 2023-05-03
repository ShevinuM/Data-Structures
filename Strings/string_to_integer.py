class Solution:
    def myAtoi(s: str) -> int:
        signs = "+"
        negative_count = 0
        new_string = ""
        found = False
        for character in s:
            if (character.isalpha() or character == ".") and not found:
                return 0
            if not character.isdigit() and found:
                break
            elif character.isspace() and not found:
                if len(signs) >= 2:
                    return 0
                continue
            elif (character == "+" or character == "-") and not found:
                signs += character
            elif character.isdigit():
                found = True
                new_string += character
        num = int(new_string) if new_string != "" else 0
        if len(signs)>2:
            return 0
        for sign in signs:
            if sign == "-":
                negative_count += 1
        if negative_count % 2 == 0:
            return (2**31)-1 if num > (2**31)-1 else num
        else:
            return -(2**31) if num > (2**31) else -num

class Test:
    print()
    print("Test for String to Integer (atoi) - LeetCode 8")
    print("______________________________________________")
    print("s = '42', expected = 42, output = {}".format(Solution.myAtoi('42')))
    print()
    print("s = '   -42', expected = -42, output = {}".format(Solution.myAtoi('   -42')))
    print()
    print("s = '4193 with words', expected = 4193, output = {}".format(Solution.myAtoi('4193 with words')))
    print()

Test()