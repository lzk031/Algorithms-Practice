// You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

// Each 0 marks an empty land which you can pass by freely.
// Each 1 marks a building which you cannot pass through.
// Each 2 marks an obstacle which you cannot pass through.
// For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

// 1 - 0 - 2 - 0 - 1
// |   |   |   |   |
// 0 - 0 - 0 - 0 - 0
// |   |   |   |   |
// 0 - 0 - 1 - 0 - 0
// The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.

// Note:
// There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
public class Solution {
    private int[] DR = new int[]{0, 0, 1, -1};
    private int[] DC = new int[]{1, -1, 0, 0};
    
    public int shortestDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[][] reach = new int[rows][cols];
        int[][] dist = new int[rows][cols];
        
        int count = 0;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    BFS(grid, reach, dist, i, j);
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (grid[i][j] == 0 && reach[i][j] == count) {
                    if (min > dist[i][j]) {
                        min = dist[i][j];
                    }
                }
            }
        }
        
        return min==Integer.MAX_VALUE ? -1 : min;
    }
    
    private void BFS(int[][] grid, int[][] reach, int[][] dist, int row, int col) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j=0; j<size; j++) {
                int[] cur = queue.poll();
                if (grid[cur[0]][cur[1]] == 0) {
                    reach[cur[0]][cur[1]]++;
                    dist[cur[0]][cur[1]] += level;
                }
                for (int i=0; i<4; i++) {
                    int r = cur[0] + DR[i];
                    int c = cur[1] + DC[i];
                    if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) continue;
                    if (visited[r][c]) continue;
                    if (grid[r][c] == 0) {
                        queue.add(new int[]{r, c});
                        visited[r][c] = true;
                    }
                }
            }
            level++;
        }
    }
}