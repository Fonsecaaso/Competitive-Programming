// Permutations II

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums==null || nums.length==0) return ans;
        boolean[] visited = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(nums,visited,list,ans);

        return ans;
    }

    private void backtrack(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> ans){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if(visited[i]) continue;
            if(i>0 && nums[i]==nums[i-1] && !visited[i-1]) continue;
            visited[i] = true;
            list.add(nums[i]);
            backtrack(nums,visited,list,ans);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }    
}
