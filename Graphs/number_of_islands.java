import java.util.HashSet;
import java.util.Set;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four
 * edges of the grid are all surrounded by water.
 */

 class Solution {
    public int numIslands(char[][] grid) {
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        Pair<Integer, Integer> dimentions = new Pair<Integer, Integer>(grid.length, grid[0].length);
        int islands = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                Pair<Integer, Integer> pair = new Pair<>(row, col);
                if (grid[row][col] == '1' && !visited.contains(pair)) {
                    visited = bfs(pair, visited, dimentions, grid);
                    islands++;
                }
            }
        }

        return islands;

    }

    public Set<Pair<Integer,Integer>> bfs(Pair<Integer, Integer> pair, Set<Pair<Integer, Integer>> visited, Pair<Integer, Integer> dimentions, char[][] grid) {
        Deque<Pair<Integer, Integer>> iterateQueue = new ArrayDeque<>();
        visited.add(pair);
        iterateQueue.add(pair);

        while (!iterateQueue.isEmpty()) {
            pair = iterateQueue.removeFirst();
            int row = pair.getKey();
            int col = pair.getValue();
            int[][] moves = {{0,1},{0,-1},{1,0},{-1,0}};
            for (int[] move: moves) {
                int nextRow = move[0];
                int nextCol = move[1];
                Pair<Integer, Integer> newPair = new Pair<>(row+nextRow, col+nextCol);
                if (row+nextRow >= 0 && row+nextRow < dimentions.getKey() && 
                col+nextCol >= 0 && col+nextCol < dimentions.getValue() &&
                    grid[row+nextRow][col+nextCol] == '1' && 
                    !visited.contains(newPair)) {
                        iterateQueue.add(newPair);
                        visited.add(newPair);
                    }
            }
        }
        return visited;

    }

   
}