//recursion with memoization O(m*n) O(m+n)
class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m+1][n+1];
        return aux(m,n);
    }

    private int aux(int m, int n){
        if(m==1 || n==1) return 1;
        if(memo[m][n]!=0) return memo[m][n];

        memo[m][n] = aux(m,n-1)+aux(m-1,n);

        return memo[m][n];
    }
}
