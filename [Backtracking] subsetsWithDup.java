// SUBSETS II

class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();

        Arrays.sort(nums);
        helper(nums,0, new ArrayList<>());

        return ans;
    }

    void helper(int[] nums, int index, List<Integer> list){
        ans.add(new ArrayList<>(list));

        for(int i=index; i<nums.length; i++){
            if(i!=index && nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            helper(nums, i+1, list);
            list.remove(list.size()-1);
        }
    }
}
