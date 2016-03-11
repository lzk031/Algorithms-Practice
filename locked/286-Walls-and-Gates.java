// You are given a m x n 2D grid initialized with these three possible values.

// -1 - A wall or an obstacle.
// 0 - A gate.
// INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
// Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

// For example, given the 2D grid:
// INF  -1  0  INF
// INF INF INF  -1
// INF  -1 INF  -1
//   0  -1 INF INF
// After running your function, the 2D grid should be:
//   3  -1   0   1
//   2   2   1  -1
//   1  -1   2  -1
//   0  -1   3   4

public class Solution {
    private static final int INF = Integer.MAX_VALUE;
    private static final int[] DR = new int[]{1, -1, 0, 0};
    private static final int[] DC = new int[]{0, 0, 1, -1};
    
    public void wallsAndGates(int[][] rooms) {
        if (rooms==null || rooms.length==0) return;
        int rows = rooms.length;
        int cols = rooms[0].length;
        BFS(rooms);
        return;
    }
    
    private class Point {
        int row, col;
        public Point(int r, int c) {
            row = r;
            col = c;
        }
    }
    
    private void BFS(int[][] rooms) {
        int rows = rooms.length;
        int cols = rooms[0].length;
        boolean visited[][] = new boolean[rows][cols];
        Queue<Point> queue = new LinkedList<Point>();
        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (rooms[r][c]==0) {
                    queue.add(new Point(r, c));
                    visited[r][c] = true;
                }
            }
        }
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                Point cur = queue.poll();
                int row = cur.row;
                int col = cur.col;
                if (rooms[row][col]>0) {
                    rooms[row][col] = Math.min(rooms[row][col], level);
                }
                
                for (int j=0; j<4; j++) {
                    int newRow = row+DR[j];
                    int newCol = col+DC[j];
                    if (newRow<0 || newRow>rows-1 || newCol<0 || newCol>cols-1) {
                        continue;
                    }
                    if (visited[newRow][newCol] || rooms[newRow][newCol]==-1) continue;
                    queue.add(new Point(newRow, newCol));
                    visited[newRow][newCol] = true;
                }
            }
            level++;
        }
        
    }
}