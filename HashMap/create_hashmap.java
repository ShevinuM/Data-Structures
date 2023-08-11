/**
 * You've created a new programming language and decided to add hashmap support
 * to it.
 * You are implementing a hashmap that has the following operations:
 * - insert x y: Insert an object with key x and value y.
 * - get x: Return the value of an object with key x.
 * - addToKey x: Add x to all keys in the map.
 * - addToValue y: Add y to all values in the map.
 *
 * Your task is to implement this hashmap, apply the given queries, and find the
 * sum of all the results for get operations.
 *
 * Example:
 * For queryType = ["insert", "insert", "addToValue", "addToKey", "get"] and
 * query = [[1, 2], [2, 3], [2], [1], [3]], the output should be
 * solution(queryType, query) = 5.
 * The hashmap looks like this after each query:
 * 1 query: {1: 2}
 * 2 query: {1: 2, 2: 3}
 * 3 query: {1: 4, 2: 5}
 * 4 query: {2: 4, 3: 5}
 * 5 query: answer is 5
 * The result of the last get query for 3 is 5 in the resulting hashmap.
 *
 * For queryType = ["insert", "addToValue", "get", "insert", "addToKey",
 * "addToValue", "get"] and query = [[1, 2], [2], [1], [2, 3], [1], [-1], [3]],
 * the output should be solution(queryType, query) = 6.
 * The hashmap looks like this after each query:
 * 1 query: {1: 2}
 * 2 query: {1: 4}
 * 3 query: answer is 4
 * 4 query: {1: 4, 2: 3}
 * 5 query: {2: 4, 3: 3}
 * 6 query: {2: 3, 3: 2}
 * 7 query: answer is 2
 * The sum of the results for all the get queries is equal to 4 + 2 = 6.
 *
 * Input:
 * - queryType: Array of query types. Guaranteed that each queryType[i] is
 * either "addToKey", "addToValue", "get", or "insert".
 * Guaranteed constraints: 1 ≤ queryType.length ≤ 105.
 * - query: Array of queries, where each query is represented either by two
 * numbers for insert query or by one number for other queries. Guaranteed that
 * during all queries all keys and values are in the range [-109, 109].
 * Guaranteed constraints: query.length = queryType.length, 1 ≤ query[i].length
 * ≤ 2.
 *
 * Output:
 * - integer64: The sum of the results for all get queries.
 */

class Solution {
    public long solution(String[] queryType, int[][] query) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int keyOffset = 0, valOffset = 0;
        long res = 0;

        for (int index = 0; index < queryType.length; index++) {

            switch (queryType[index]) {
                case "insert":
                    map.put(query[index][0] - keyOffset, query[index][1] - valOffset);
                    break;

                case "get":
                    res += map.get(query[index][0] - keyOffset) + valOffset;
                    break;

                case "addToValue":
                    valOffset += query[index][0];
                    break;

                case "addToKey":
                    keyOffset += query[index][0];
                    break;
            }

        }
        return res;
    }
}
