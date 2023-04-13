// Combination Sum

class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new ArrayList<>();
        helper(0,candidates,new ArrayList<>(),target);

        return ans;
    }

    void helper(int index, int[] cand, List<Integer> list, int target){
        if(target<0) return;
        
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=index; i<cand.length; i++){
            list.add(cand[i]);
            helper(i,cand,list,target-cand[i]);
            list.remove(list.size()-1);
        }
    }
}
