# This was my initial solution and I found it to be too much code
class Solution1:
    def chooseInteger(character) -> str:
        switcher = {
            "I": "1",
            "V": "5",
            "X": "10",
            "L": "50",
            "C": "100",
            "D": "500",
            "M": "1000",
            "A": "4",
            "B": "9",
            "H": "40",
            "E": "90",
            "F": "400",
            "G": "900"
        }
        return switcher.get(character)

    def edgeCases(curr, next, character) -> str:
        if curr == "I":
            if next == "V":
                character = "A"
            elif next == "X":
                character = "B"
        elif curr == "X":
            if next == "L":
                character = "H"
            elif next == "C":
                character = "E"
        elif curr == "C":
            if next == "D":
                character = "F"
            elif next == "M":
                character = "G"
        return character

    def romanToInt(s: str) -> int:
        len_s = len(s)
        int_op = 0
        count = 0
        while count < len_s:
            curr = s[count]
            next = s[count+1] if count+1 < len_s else "n"
            character = Solution.edgeCases(curr, next, curr)
            count = count + 2 if character != curr else count + 1
            character = Solution.chooseInteger(character)
            int_op = int_op + int(character)
            
        return int_op


class Solution2:
    def romanToInt(s: str) -> int:
        sum = 0
        len_s = len(s)
        count = 0
        roman_numerals = {"I" : 1, "V" : 5, "X" : 10, "L" : 50, "C" : 100, "D" : 500, "M" : 1000}
        while count < len_s:
            prev = 0 if count-1 < 0 else roman_numerals.get(s[count-1])
            curr = roman_numerals.get(s[count])
            sum = sum + curr - 2*prev if prev < curr else sum + curr
            count+=1
        return sum
    
    def testSol2():
        print(Solution2.romanToInt("III"))
        print(Solution2.romanToInt("LVIII"))
        print(Solution2.romanToInt("MCMXCIV"))

Solution2.testSol2()