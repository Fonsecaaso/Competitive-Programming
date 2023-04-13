//Combination Sum II

class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,0,new ArrayList<>(), target);
        return ans;
    }

    private void helper(int[] candidates, int index, List<Integer> list, int target){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=index; i<candidates.length; i++){
            if(i > index && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) break;

            list.add(candidates[i]);
            helper(candidates,i+1,list,target-candidates[i]);
            list.remove(list.size()-1);
        }
    }
}
