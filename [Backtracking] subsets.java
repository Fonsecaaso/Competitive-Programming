// SUBSETS

class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(0, nums, list);
        return ans;
    }

    void helper(int index, int[] nums, List<Integer> list){
        ans.add(new ArrayList<>(list));
    
        for(int i=index; i<nums.length; i++){
            list.add(nums[i]);
            helper(i+1,nums,list);
            list.remove(list.size()-1);
        }
    }
}
