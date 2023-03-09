class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int up=0, down=matrix.length-1,left=0, right=matrix[0].length-1;

        while(up<=down && left<=right){
            for(int i=left; i<=right; i++)
                ans.add(matrix[up][i]);
            up++;

            for(int i=up; i<=down; i++)
                ans.add(matrix[i][right]);
            right--;

            if(up<=down){
                for(int i=right; i>=left; i--)
                    ans.add(matrix[down][i]);
                down--;
            }

            if(left<=right){
                for(int i=down; i>=up; i--)
                    ans.add(matrix[i][left]);
                left++;  
            }          
        }

        return ans;
    }
}

/*
54. Spiral Matrix
Given an m x n matrix, return all elements of the matrix in spiral order.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
*/
