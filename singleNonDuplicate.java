/*
540. Single Element in a Sorted Array

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.
*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo=0, hi=nums.length-1;

        while(lo<hi){
            int mid = (lo+hi)/2;
            
            if(mid%2==1) mid--;

            if(nums[mid]!=nums[mid+1])
                hi = mid;

            else
                lo = mid+2;      
        }

        return nums[lo];
    }
}
