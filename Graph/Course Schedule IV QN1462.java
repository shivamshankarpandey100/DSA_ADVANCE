//https://leetcode.com/problems/course-schedule-iv

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] visited = new boolean[numCourses][numCourses];
        for (int[] pair : prerequisites) {
            visited[pair[0]][pair[1]] = true;
        }
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    visited[i][j] = visited[i][j] || (visited[i][k] && visited[k][j]);
                }
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(visited[query[0]][query[1]]);
        }
        return result;
    }
}