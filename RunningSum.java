/*
1480. Running Sum of 1d Array

Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.
*/

class Solution {
    public int[] runningSum(int[] nums) {
        if(nums.length == 0) return new int[0];
        
        int[] ans = new int[nums.length];
        ans[0] = nums[0];

        for(int i=1; i<nums.length; i++){
            ans[i] = ans[i-1] + nums[i];
        }

        return ans;
    }
}
