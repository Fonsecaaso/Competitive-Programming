// Maximum Product Subarray

// straighforward O(n²)
class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0]*nums[1],Math.max(nums[0],nums[1]));
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            int mul = nums[i];
            max = Math.max(max,mul);
            for(int j=i+1; j<nums.length; j++){
                mul *= nums[j];
                max = Math.max(max,mul);
            }
        }
        return max;
    }
}

// optimized O(n)
class Solution {
    public int maxProduct(int[] nums) {
        int prod = 1, ans = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            prod *= nums[i];
            ans = Math.max(ans,prod);
            if(prod==0) prod = 1;
        }

        prod = 1;

        for(int i=nums.length-1; i>=0; i--){
            prod *= nums[i];
            ans = Math.max(ans,prod);
            if(prod==0) prod = 1;
        }

        return ans;
    }
}
