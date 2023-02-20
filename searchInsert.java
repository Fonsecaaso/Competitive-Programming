/*
35. Search Insert Position
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        int mid=(lo+hi)/2, value;
        
        while(lo<hi){
            mid = (hi+lo)/2;
            value = nums[mid];
            if(value==target) return mid;
            if(value>target)
                hi = mid;
            if(value<target)
                lo = mid+1;
        }
        
        return nums[lo] < target ? lo + 1: lo;
    }
}
