//417. Pacific Atlantic Water Flow

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] pacific = new int[m][n];
        int[][] atlantic = new int[m][n];

        for(int i=0; i<m; i++){
            pacific[i] = Arrays.copyOf(heights[i], n);
            atlantic[i] = Arrays.copyOf(heights[i], n);
        }

        for(int j=0; j<n; j++){
            pacific[0][j] = -1;
            atlantic[m-1][j] = -1;
            BFS(pacific, 0, j, heights);
            BFS(atlantic, m-1, j, heights);
        }
        for(int i=0; i<m; i++){
            pacific[i][0] = -1;
            atlantic[i][n-1] = -1;
            BFS(pacific, i, 0, heights);
            BFS(atlantic, i, n-1, heights);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pacific[i][j]==-1 && atlantic[i][j]==-1)
                    ans.add(Arrays.asList(i,j));
            }
        }

        return ans;
    }

    private void BFS(int[][] ocean, int i, int j, int[][] heights){
        if (i>0 && ocean[i-1][j]!=-1 && ocean[i-1][j] >= heights[i][j]){
            ocean[i-1][j] = -1;
            BFS(ocean, i-1, j, heights);
        } 
        if (j>0 && ocean[i][j-1]!=-1 && ocean[i][j-1] >= heights[i][j]){
            ocean[i][j-1] = -1;
            BFS(ocean, i, j-1, heights);
        } 
        if (i<ocean.length-1 && ocean[i+1][j]!=-1 && ocean[i+1][j] >= heights[i][j]){
            ocean[i+1][j] = -1;
            BFS(ocean, i+1, j, heights);
        } 
        if (j<ocean[0].length-1 && ocean[i][j+1]!=-1 && ocean[i][j+1] >= heights[i][j]){
            ocean[i][j+1] = -1;
            BFS(ocean, i, j+1, heights);
        } 
    }
}
