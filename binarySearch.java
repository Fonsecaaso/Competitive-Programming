class Solution {
    public int search(int[] nums, int target) {
        int lo=0, hi=nums.length-1, val, mid;

        while(lo<=hi){
            mid = (lo+hi)/2;
            val = nums[mid];

            if(val==target) return mid;
            if(val>target) hi=mid-1;
            else lo = mid+1;
        }
        return -1;
    }
}
