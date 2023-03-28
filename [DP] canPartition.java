// Partition Equal Subset Sum

//recursive 2^n
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums)
            sum+=num;

        if(sum%2!=0) return false;

        Arrays.sort(nums);

        return helper(0,0,nums,sum/2);
    }

    boolean helper(int curr, int index, int[] nums, int target){
        if(curr>target || index==nums.length) return false;
        if(curr==target) return true;
        return helper(curr+nums[index], index+1, nums, target) || helper(curr, index+1, nums, target);
    }
}

// KNAPSACK O(n*sum(nums)/2)
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums)
            sum+=num;

        if(sum%2!=0) return false;

        boolean[][] memo = new boolean[nums.length+1][sum/2 + 1];

        for(int i=0; i<memo.length; i++){
            for(int j=0; j<memo[0].length; j++){
                memo[i][j] = false;
            }
        }

        memo[0][0] = true;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= sum / 2 ; j++) {
                if (j - nums[i - 1] >= 0){
                    memo[i][j] = memo[i - 1][j - nums[i - 1]]||memo[i - 1][j];
                }
                else{
                    memo[i][j] = memo[i - 1][j];
                }
            }
        }

        return memo[nums.length][sum/2];
    }
}
