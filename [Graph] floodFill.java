class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Set<List<Integer>> visited = new HashSet<>();
        fill(image,sr,sc,color,visited);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int color,Set<List<Integer>> visited){
        List<Integer> curr = Arrays.asList(sr,sc);
        
        if(visited.contains(curr)) return;
        visited.add(curr);
        
        int currColor = image[sr][sc];
        image[sr][sc] = color;

        if(sr>0 && currColor==image[sr-1][sc]) fill(image,sr-1,sc,color,visited);
        if(sc>0 && currColor==image[sr][sc-1]) fill(image,sr,sc-1,color,visited);
        if(sr<image.length-1 && currColor==image[sr+1][sc]) fill(image,sr+1,sc,color,visited);
        if(sc<image[0].length-1 && currColor==image[sr][sc+1]) fill(image,sr,sc+1,color,visited);
    }
}

/*
733. Flood Fill

An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.

Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
*/
