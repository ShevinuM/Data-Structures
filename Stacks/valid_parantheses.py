'''
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.
'''

def isValid(s: str) -> bool:
    stack = []
    bracketsMap = {")":"(", "}":"{", "]":"["}
    for char in s:
        if char in bracketsMap:
            if stack and stack[-1] == bracketsMap[char]:
                stack.pop()
            else:
                return False
        else:
            stack.append(char)
    return not stack

def Test():
    print(isValid(s = "()"))
    print(isValid(s = "()[]{}"))
    print(isValid(s = "(]"))

Test()