/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array 
 * prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course 
 * ai. 
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1. 
 * Return true if you can finish all courses. Otherwise, return false.
 * 
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is
 * possible.
 * 
 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take
 * course 0 you should also have finished course 1. So it is impossible.
 * 
 * Constraints:
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 */

 class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Create the adjacency list for each course with empty arraylists
        ArrayList<Integer>[] adjList = new ArrayList[numCourses];
        for (int index = 0; index < numCourses; index++) {
            adjList[index] = new ArrayList<>();
        }

        // Add the pre-requisites for each course of the adjacency list
        int course, pre;
        for (int[] preq : prerequisites) {
            course = preq[0];
            pre = preq[1];
            adjList[course].add(pre);
        }

        // I'm taking a recursive approach and checking if I can finish each course using the canFinish method.
        Boolean canFinish;
        Set<Integer> visited = new HashSet<>();
        for (int index = 0; index < numCourses; index++) {
            canFinish = checkIfCan(index, adjList, visited);
            if (!canFinish) { return false; }
        }

        return true;
    }
    
    /**
     * This method checks if the course at the given index can be finished. It does this by checking if the course has
     * already been visited which indicates a loop. If it has, then it returns false. If it hasn't, then it checks if the course has any pre-requisites. If it doesn't, then it returns true. If it does, then it recursively checks if each
     * pre-requisite can be finished. If any of the pre-requisites can't be finished, then it returns false. If all of the
     * pre-requisites can be finished, then it returns true.
     */
    public boolean checkIfCan(int index, ArrayList<Integer>[] adjList, Set<Integer> visited) {
        if (visited.contains(index)) { return false; }
        ArrayList<Integer> preqs = adjList[index];
        if (preqs.size() == 0) { return true; }
        visited.add(index);
        for (int preq : preqs) {
            if (!checkIfCan(preq, adjList, visited)) { return false; }
        }
        visited.remove(index);
        adjList[index] = new ArrayList<>();
        return true;
    }
}