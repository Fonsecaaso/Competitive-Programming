// Coin Change

// recursive with memoization O(n) O(n)
class Solution {
    public int coinChange(int[] coins, int amount) {
        return helper(coins, amount, new int[amount]);
    }

    int helper(int[] coins, int remain, int[] amount){
        if(remain < 0) return -1;
        if(remain == 0) return 0;

        if(amount[remain-1]!=0) return amount[remain-1];

        int min = Integer.MAX_VALUE;

        for(int coin:coins){
            int res = helper(coins, remain-coin, amount);
            if (res >= 0 && res<min) min = res + 1;
        }

        amount[remain-1] = min == Integer.MAX_VALUE ? -1:min;     
        return amount[remain-1];  
    }
}

// iterative DP O(n) O(n)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<amount;i++){
            if(dp[i]==Integer.MAX_VALUE)continue;
            for(int j:coins){
                if(j>amount||i+j>amount)continue;
                dp[i+j]=Math.min(dp[i+j],dp[i]+1);
            }
        }
        if(dp[amount]==Integer.MAX_VALUE)dp[amount]=-1;
        return dp[amount];
    }
}


// python

def coinsChange(coins, amount):
	minimalChange = minimalChange(coins, amount, 0)
	if minimalChange != float('inf'):
  	return minimalChange
  return -1
  
def minimalChangeValue(coins, amount, coinsUsed):
	if amount < 0:
  	return float('inf')
  if amount == 0:
  	return coinsUsed
	minimalChange = float('inf')
  for coin in coins:
  	restToCalculate = amount - coin
  	if restToCalculate in memo: 
    	return memo[restToCalculate]
    currMinimalChange = minimalChangeValue(coins, restToCalculate, coinsUsed + 1) 
  	minimalChange = min(minimalChange, currMinimalChange)
  memo[amount] = minimalChange
  return minimalChange 
