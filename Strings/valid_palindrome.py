def isPalindrome( s: str) -> bool:
    new_string = ""
    for character in s:
        if character.isalnum():
            new_string+=character.lower()
    return True if new_string == new_string[::-1] else False

def test(s):
    print("Input : {0} \n"
          "Output: {1}".format(s, isPalindrome(s)))
    print()

test("A man, a plan, a canal: Panama")
test("race a car")
test(" ")