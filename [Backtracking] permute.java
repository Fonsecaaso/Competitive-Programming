//Permutations

class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        help(nums,new ArrayList<>());
        return ans;
    }

    private void help(int[] nums, List<Integer> list){
        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(list.contains(nums[i])) continue;

            list.add(nums[i]);
            help(nums,list);
            list.remove(list.size()-1);
        }
    }
}
