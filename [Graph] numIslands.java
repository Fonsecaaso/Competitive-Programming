class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, count=0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if (grid[i][j]=='1'){
                    visit(grid,i,j);
                    count++;
                }
            }
        }

        return count;
    }

    private static void visit(char[][] grid, int i, int j){
        if(grid[i][j]=='0') return;
        grid[i][j]='0';

        if(i>0) visit(grid,i-1,j);
        if(j>0) visit(grid,i,j-1);
        if(i<grid.length-1) visit(grid,i+1,j);
        if(j<grid[0].length-1) visit(grid,i,j+1);
    }
}

/*
200. Number of Islands

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 
Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
*/
