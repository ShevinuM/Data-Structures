'''
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
'''

def generate(numRows):
    output_rows = []
    for row in range(0, numRows):
        output_rows.append([])
        for index in range(0, row+1):
            if row == 0 or row == 1 or index == 0 or index >= len(output_rows[row-1]):
                value = 1 
            else:
                value = output_rows[row-1][index-1] + output_rows[row-1][index]
            output_rows[row].append(value)
    return output_rows

def test(numRows):
    print("Number of Rows: {0}, Output: {1}".format(numRows, generate(numRows)))

test(5)
test(1)
