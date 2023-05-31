'''
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
'''

class Solution1:
    def gameOfLife(self, board) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        '''
        In this solution we first iterate over the board and put the next state into a python dictionary(hashmap)
        which contains the position and the next state. Then we update the board. However, this solution doesn't
        modify the board with constant time complexity
        '''
        no_of_rows, no_of_columns = len(board), len(board[0])
        next_state_dict = {}
        for row in range(no_of_rows):
            for column in range(no_of_columns):

                live_neighbours = 0
                if column+1 < no_of_columns and board[row][column+1] == 1:
                    live_neighbours += 1
                if column != 0 and board[row][column-1] == 1:
                    live_neighbours += 1
                if row != 0 and board[row-1][column] == 1:
                    live_neighbours += 1
                if row+1 < no_of_rows and board[row+1][column] == 1:
                    live_neighbours += 1
                if row != 0 and column != no_of_columns-1 and board[row-1][column+1] == 1:
                    live_neighbours += 1
                if row != no_of_rows-1 and column != no_of_columns-1 and board[row+1][column+1] == 1:
                    live_neighbours += 1
                if row != 0 and column != 0 and board[row-1][column-1] == 1:
                    live_neighbours += 1
                if row != no_of_rows-1 and column != 0 and board[row+1][column-1] == 1:
                    live_neighbours += 1

                if board[row][column] == 1: # is a live cell
                    if live_neighbours < 2 or live_neighbours > 3:
                        next_state_dict[(row,column)]= 0
                    else:
                        next_state_dict[(row,column)] = 1
                else: # is a dead cell
                    if live_neighbours == 3:
                        next_state_dict[(row,column)] = 1
                    else:
                        next_state_dict[(row,column)] = 0
        
        for (row, column), state in next_state_dict.items():
            board[row][column] = state