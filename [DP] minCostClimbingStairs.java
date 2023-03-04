//recursive O(n²) O(n)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(aux(cost,0,0),aux(cost,1,0));
    }

    private int aux(int[] cost, int index, int amount){
        if(index>=cost.length) return amount;
        amount+=cost[index];
        return Math.min(aux(cost,index+1,amount),aux(cost,index+2,amount));
    }
}

//recursive with memoization O(n) O(n)
class Solution {
    int[] memo;

    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length];
        Arrays.fill(memo,-1);
        return Math.min(aux(cost,0,0),aux(cost,1,0));
    }

    private int aux(int[] cost, int index, int amount){
        if(index>=cost.length) return amount;
        if(memo[index]>-1) return memo[index];
        memo[index] = cost[index] + Math.min(aux(cost,index+1,amount),aux(cost,index+2,amount));

        return memo[index];
    }
}
