class Solution {
    Set<List<Integer>> visited;
    public boolean exist(char[][] board, String word) {
        visited = new HashSet<>();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(exist(i, j, board, word, 0)) return true;
            }
        } 

        return false;
    }

    private boolean exist(int i, int j, char[][] board, String word, int index){
        if(index==word.length()) return true;
        int m=board.length, n=board[0].length;
        if(i<0 || j<0 || i==m || j==n) return false;
        if(board[i][j]!=word.charAt(index)) return false;

        // if(visited.contains(Arrays.asList(i,j))) return false;
        // visited.add(Arrays.asList(i,j));
	      board[i][j] = '*';

        
        boolean exist = exist(i+1, j, board, word, index+1)
                        || exist(i, j+1, board, word, index+1)
                        || exist(i-1, j, board, word, index+1)
                        || exist(i, j-1, board, word, index+1);


        // visited.remove(Arrays.asList(i,j));
	      board[i][j] = word.charAt(index);

        return exist;
    }
}

/*
79. Word Search
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
*/
