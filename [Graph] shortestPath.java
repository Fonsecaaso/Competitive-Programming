//1293. Shortest Path in a Grid with Obstacles Elimination

class Solution {
    Queue<Coordinate> queue;
    boolean[][][] visited;

    public int shortestPath(int[][] grid, int k) {
        Coordinate coordinate = new Coordinate(0,0,k,0);
        int m = grid.length-1, n = grid[0].length-1; 

        queue = new LinkedList<>();
        visited = new boolean[grid.length][grid[0].length][k+1];

        queue.add(coordinate);
        visited[0][0][k] = true;

        while(!queue.isEmpty()){
            Coordinate curr = queue.poll();            
            if(curr.x == m && curr.y == n) return curr.steps;

            processNext(curr,grid);
        }

        return -1;
    }

    private void processNext(Coordinate curr, int[][] grid){
        int x = curr.x, y = curr.y, credits = curr.credits, steps = curr.steps;
        int[] dirs = {0,1,0,-1,0};
        for(int i=0; i<4; i++){
            int nx = x+dirs[i], ny = y+dirs[i+1];
            if(nx<0 || ny<0 || nx==grid.length || ny==grid[0].length) continue;
            Coordinate coordinate = new Coordinate(nx,ny,credits,steps+1);
            if(grid[nx][ny]==1) coordinate.credits--;
            if(coordinate.credits>=0 && !visited[nx][ny][coordinate.credits]){
                visited[nx][ny][coordinate.credits] = true;
                queue.add(coordinate);
            }
        }
    }
}

class Coordinate{
    public int x;
    public int y;
    public int credits;
    public int steps;

    public Coordinate(int x, int y, int credits, int steps){
        this.x = x;
        this.y = y;
        this.credits = credits;
        this.steps = steps;
    }
}
