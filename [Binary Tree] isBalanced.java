//Balanced Binary Tree

class Solution {
    boolean ans;
    public boolean isBalanced(TreeNode root) {
        ans = true;
        aux(root);
        return ans;
    }

    int aux(TreeNode node){
        if(node == null) return 0;

        int left = aux(node.left);
        int right = aux(node.right);

        if(Math.abs(left-right)>1) ans = false;

        return Math.max(left,right)+1;
    }
}
