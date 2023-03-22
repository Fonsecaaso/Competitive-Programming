//437. Path Sum III

class Solution {
    int count;
    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        aux(root,targetSum,targetSum, new HashSet<>());
        return count;
    }

    void aux(TreeNode root, long targetSum, long targetSumOriginal, Set<TreeNode> visited){
        if(root==null || root.val==Math.pow(10,9)) return;
        if(Math.abs(targetSum-root.val) == 0) count++;

        if(root.left!=null) {
            aux(root.left,targetSum-root.val, targetSumOriginal, visited);
            if(!visited.contains(root.left)){
                visited.add(root.left);
                aux(root.left,targetSumOriginal, targetSumOriginal, visited);
            }
        }
        if(root.right!=null){
            aux(root.right,targetSum-root.val, targetSumOriginal, visited);
            if(!visited.contains(root.right)){
                visited.add(root.right);
                aux(root.right,targetSumOriginal, targetSumOriginal, visited);
            }
        }
    }
}
