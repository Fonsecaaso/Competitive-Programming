class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, Long min, Long max){
        if (root == null) return true;
        if (root.val>=max || root.val<=min) return false;
        return isValidBST(root.left,min,new Long(root.val)) && isValidBST(root.right,new Long(root.val),max);
    }
}
