//1254. Number of Closed Islands

class Solution {
    boolean flag = true;
    int[][] grid;

    public int closedIsland(int[][] grid) {
        int ans = 0;
        this.grid=grid;
        
        for(int i=1; i<grid.length-1; i++){
            for(int j=1; j<grid[0].length-1; j++){

                if(grid[i][j]==0){
                    dfs(i,j);
                    if(flag) ans++;
                    flag = true;
                }
            }
        }

        return ans;
    }

    private void dfs(int i, int j){
        if(i<0 || j<0 || i==grid.length || j==grid[0].length || grid[i][j]==1) return;
        if((i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1) && grid[i][j]==0) flag = false;

        grid[i][j]=1;

        dfs(i-1,j);
        dfs(i+1,j);
        dfs(i,j-1);
        dfs(i,j+1);
    }
}

